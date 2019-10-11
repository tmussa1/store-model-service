package com.cscie97.store.model;


import java.time.LocalDateTime;

public class Customer {

    private String customerId;
    private String firstName;
    private String lastName;
    private CustomerType customerType;
    private String emailAddress;
    private String accountAddress;
    private InventoryLocation customerLocation;
    private LocalDateTime timeLastSeen;
    private Basket basket;

    public Customer(String customerId, String firstName, String lastName, CustomerType customerType, String emailAddress, String accountAddress) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerType = customerType;
        this.emailAddress = emailAddress;
        this.accountAddress = accountAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public InventoryLocation getCustomerLocation() {
        return customerLocation;
    }

    public LocalDateTime getTimeLastSeen() {
        return timeLastSeen;
    }

    public void setCustomerLocation(InventoryLocation customerLocation) {
        setTimeLastSeen(LocalDateTime.now());
        this.customerLocation = customerLocation;
    }

    public void setTimeLastSeen(LocalDateTime timeLastSeen) {
        this.timeLastSeen = timeLastSeen;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerType=" + customerType +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountAddress='" + accountAddress + '\'' +
                ", timeLastSeen=" + timeLastSeen +
                ", basket=" + basket +
                '}';
    }
}
