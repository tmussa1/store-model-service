package com.cscie97.store.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreModelService implements IStoreModelService {

    private List<Customer> customers;
    private List<Store> stores;
    private Map<Integer, Inventory> inventoryMap;
    private Map<Integer, Product> productMap;

    public StoreModelService() {
        this.customers = new ArrayList<>();
        this.stores = new ArrayList<>();
        this.inventoryMap = new HashMap<>();
        this.productMap = new HashMap<>();
    }

    @Override
    public Store createAStore(String storeId, String storeName, String storeAddress) throws StoreException {
        String [] addressArray = storeAddress.split(" ");
        if(addressArray.length != 3){
            throw new StoreException("You need to pass in street, city and state in that order");
        }
        Address address = new Address(addressArray[0], addressArray[1], addressArray[2]);
        checkValidityOfStoreId(storeId);
        return new Store(storeId, storeName, address);
    }

    private void checkValidityOfStoreId(String storeId) throws StoreException {
        Store duplicateStore = this.stores.stream().filter(store -> store.getStoreId().equals(storeId)).findAny().get();
        if(duplicateStore != null){
            throw new StoreException("Duplicate Store with the ID provided exists. Store creation failed");
        }
    }

    @Override
    public Store getStoreById(String storeId) throws StoreException {
        Store store = this.stores.stream().filter(astore -> astore.getStoreId().equals(storeId)).findAny().get();
        if(store == null){
            throw new StoreException("A store with the requested id doesn't exist");
        }
        return store;
    }

    @Override
    public Aisle createAisle(String storeId, String aisleNumber, String aisleDescription, String location) throws StoreException {
        Store store = getStoreById(storeId);
        Location locationEnum = StoreUtil.convertLocationToEnum(location);
        Aisle aisle = new Aisle(aisleNumber, aisleDescription,locationEnum);
        store.addAisleToAStore(aisle);
        return aisle;
    }

    @Override
    public Aisle getAisleByStoreIdAndAisleNumber(String storeId, String aisleNumber) throws StoreException {
        Store store = getStoreById(storeId);
        Aisle aisle = store.getAisles().stream().filter(anAisle -> anAisle.getAisleNumber().equals(aisleNumber)).findAny().get();
        if(aisle == null){
            throw new StoreException("An aisle with the requested id doesn't exist");
        }
        return aisle;
    }

    @Override
    public Shelf createAShelf(String storeId, String aisleNumber, String shelfId, String shelfName, String level, String shelfDescription, String temperature) throws StoreException {
        Aisle aisle = getAisleByStoreIdAndAisleNumber(storeId, aisleNumber);
        Level levelEnum = StoreUtil.convertLevelToEnum(level);
        Temperature temperatureEnum = StoreUtil.convertTemperatureToEnum(temperature);
        Shelf shelf = new Shelf(shelfId, shelfName,levelEnum,shelfDescription,temperatureEnum);
        aisle.addShelfToAisle(shelf);
        return shelf;
    }

    @Override
    public Shelf getShelfByStoreIdAisleNumShelfId(String storeId, String aisleNumber, String shelfId) throws StoreException {
        Aisle aisle = getAisleByStoreIdAndAisleNumber(storeId, aisleNumber);
        Shelf shelf = aisle.getShelves().stream().filter(aShelf -> aShelf.getShelfId().equals(shelfId)).findAny().get();
        if(shelf == null){
            throw new StoreException("A shelf with the requested id doesn't exist");
        }
        return shelf;
    }

    @Override
    public Inventory createInventory(int inventoryId, String storeId, String aisleNumber, String shelfId, int capacity, int count, int productId) throws StoreException {
        Product product = productMap.get(productId);
        if(product == null){
            throw new StoreException("Inventory can not be created for a product that is not defined");
        }
        InventoryLocation inventoryLocation = new InventoryLocation(storeId, aisleNumber, shelfId);
        Shelf shelf = getShelfByStoreIdAisleNumShelfId(storeId, aisleNumber, shelfId);
        Inventory inventory = new Inventory(inventoryId, product, count, capacity, inventoryLocation);
        inventoryMap.put(inventoryId, inventory);
        shelf.addInventoryToShelf(inventory);
        return inventory;
    }

    @Override
    public Inventory getInventoryById(int inventoryId) throws StoreException {
        Inventory inventory = inventoryMap.get(inventoryId);
        if(inventory == null){
            throw new StoreException("Requested inventory not found in all of the stores");
        }
        return inventory;
    }

    /**
     * This makes sure the overall inventory map for all stores as well as the inventory in a particular shelf is updated.
     * The same inventory(same inventory id) can be split between stores so the count for a particular shelf maybe different
     * from the overall inventory count
     * @param inventoryId
     * @param difference
     * @return
     * @throws StoreException
     */
    @Override
    public int UpdateInventoryCount(int inventoryId, int difference) throws StoreException {
        Inventory inventoryFromAnyStore = inventoryMap.get(inventoryId);
        if(inventoryFromAnyStore == null){
            throw new StoreException("The inventory that you are trying to update the count of doesn't exist in the stores");
        }
        Shelf shelf = getShelfByStoreIdAisleNumShelfId(inventoryFromAnyStore.getInventoryLocation().getStoreId(),
                inventoryFromAnyStore.getInventoryLocation().getAisleNumber(),
                inventoryFromAnyStore.getInventoryLocation().getShelfId());
        Inventory inventoryInTheShelf = shelf.getInventoryList().stream()
                .filter(inventory -> inventory.getInventoryId() == inventoryId).findAny().get();
        if(inventoryInTheShelf == null){
            throw new StoreException("The inventory is not placed in any of the shelves");
        }
        inventoryInTheShelf.setCount(inventoryInTheShelf.getCount() + difference);
        inventoryFromAnyStore.setCount(inventoryFromAnyStore.getCount() + difference);
        return inventoryFromAnyStore.getCount();
    }

    @Override
    public Product createAProduct(int productId, String productName, String productDescription, int size, String category, int price, String temperature) {
        double volume = Math.pow(size, 3);
        Product product = new Product(productId, productName, productDescription, category, price, volume,
                StoreUtil.convertTemperatureToEnum(temperature));
        this.productMap.put(productId, product);
        return product;
    }

    @Override
    public Product getProductById(int productId) throws StoreException {
        Product product = this.productMap.get(productId);
        if(product == null){
            throw new StoreException("A product with the requested id doesn't exist");
        }
        return product;
    }

    @Override
    public Customer createCustomer(String customerId, String firstName, String lastName, String type, String emailAddress, String accountAddress) throws StoreException {
        Customer customer = new Customer(customerId, firstName, lastName,
                StoreUtil.convertCustomerTypeToEnum(type), emailAddress, accountAddress);
        duplicateCustomerValidation(customerId, accountAddress);
        this.customers.add(customer);
        return customer;
    }

    private void duplicateCustomerValidation(String customerId, String accountAddress) throws StoreException {
        Customer duplicateCustomer = this.customers.stream()
                .filter(aCustomer -> aCustomer.getCustomerId().equals(customerId)
                        && aCustomer.getAccountAddress().equals(accountAddress))
                .findAny().get();
        if(duplicateCustomer != null){
            throw new StoreException("A customer with the same id and account address exists");
        }
    }


}
