package com.cscie97.store.model;


public class Customer {

    private String customerId;
    private String firstName;
    private String lastName;
    private CustomerType customerType;
    private String emailAddress;
    private String accountAddress;

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
}
