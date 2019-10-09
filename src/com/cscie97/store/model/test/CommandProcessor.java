package com.cscie97.store.model.test;

import com.cscie97.store.model.IStoreModelService;
import com.cscie97.store.model.Store;
import com.cscie97.store.model.StoreException;
import com.cscie97.store.model.StoreModelService;

import java.io.*;

public class CommandProcessor {

    private String processCommand(IStoreModelService storeModelService, String command, int lineNumber) {
        String [] commandWords = command.split(" ");

        switch(commandWords[0].toLowerCase()){
            case "define-store":
                   try {
                       return CreateUtil.createStore(storeModelService, commandWords[1], commandWords[3], commandWords[5], commandWords[6], commandWords[7]);
                   } catch (StoreException e) {
                       return ExceptionUtil.outputException(lineNumber, "Store created failed" , e);
                   }
            case "show-store":
                try {
                    return ShowUtil.showStoreDetails(storeModelService ,commandWords[1]);
                } catch (StoreException e) {
                    return ExceptionUtil.outputException(lineNumber, "Store not found", e);
                }
            case "define-aisle":
                try{
                    String [] storeAisle = commandWords[1].split(":");
                    return CreateUtil.createAisle(storeModelService, storeAisle[0], storeAisle[1], commandWords[3], commandWords[5]);
                } catch (StoreException e) {
                    return ExceptionUtil.outputException(lineNumber, "Aisle creation failed", e);
                }
            case "show-aisle":
                try {
                    String [] storeAisle = commandWords[1].split(":");
                    return ShowUtil.showAisleDetails(storeModelService, storeAisle[0], storeAisle[1]);
                } catch (StoreException e) {
                    return ExceptionUtil.outputException(lineNumber, "Aisle not found", e);
                }
            case "define-shelf":
                try {
                    String [] storeAisleShelf = commandWords[1].split(":");
                    return CreateUtil.createShelf(storeModelService, storeAisleShelf[0], storeAisleShelf[1], storeAisleShelf[2],
                            commandWords[3], commandWords[5], commandWords[7], commandWords[9]);
                } catch (StoreException e) {
                    return ExceptionUtil.outputException(lineNumber, "Shelf not created", e);
                }
            case "show-shelf":
                try {
                    String [] storeAisleShelf = commandWords[1].split(":");
                    return ShowUtil.showShelfDetails(storeModelService, storeAisleShelf[0], storeAisleShelf[1], storeAisleShelf[2]);
                } catch (StoreException e) {
                    return ExceptionUtil.outputException(lineNumber, "Shelf not found", e);
                }
            case "define-product":
                    return CreateUtil.createProduct(storeModelService, commandWords[1], commandWords[3],
                            commandWords[5],commandWords[7],commandWords[9], commandWords[11], commandWords[13]);
            case "show-product":
                try {
                    return ShowUtil.showProductDetails(storeModelService, commandWords[1]);
                } catch (StoreException e) {
                    return ExceptionUtil.outputException(lineNumber, "Product not found", e);
                }
            case "define-inventory":
                String [] storeAisleShelf = commandWords[3].split(":");
                try {
                    return CreateUtil.createInventory(storeModelService, storeAisleShelf[0], storeAisleShelf[1],
                            storeAisleShelf[2],  commandWords[3], commandWords[5], commandWords[7], commandWords[9]);
                } catch (StoreException e) {
                    return ExceptionUtil.outputException(lineNumber, "Inventory creation failed", e);
                }
            case "show-inventory":
                try {
                    return ShowUtil.showInventoryDetails(storeModelService, commandWords[1]);
                } catch (StoreException e) {
                    return ExceptionUtil.outputException(lineNumber, "Inventory with the id not found", e);
                }
            case "update-inventory":
                    return UpdateUtil.
        }
        return DetailsUtil.endOfScript();
    }




    public void processCommandFile(String file) throws CommandProcessorException {

        try {

            File storeFile = new File(file);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(storeFile));

            int lineNumber = 0;

            IStoreModelService storeModelService = StoreModelService.getInstance();
            String command;

            while((command = bufferedReader.readLine()) != null){
                lineNumber++;
                processCommand(storeModelService, command, lineNumber);
            }

        }  catch (IOException e) {
            throw new CommandProcessorException("Error reading", "Command can not be processed ", 1);
        }
    }


}
