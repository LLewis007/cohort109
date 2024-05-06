package com.lewis.model;

import java.util.Objects;

/**
 * Customer POJO
 */
public class Customer {

    private String customerNumber;
    private String customerName;
    private String customerCity;
    private String customerState;

    public Customer(){}

    public Customer(String number, String name, String city, String state ){
        this.customerNumber = number;
        this.customerName =  name;
        this.customerCity = city;
        this.customerState = state;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getCustomerNumber(), customer.getCustomerNumber()) && Objects.equals(getCustomerName(), customer.getCustomerName()) && Objects.equals(getCustomerCity(), customer.getCustomerCity()) && Objects.equals(getCustomerState(), customer.getCustomerState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerNumber(), getCustomerName(), getCustomerCity(), getCustomerState());
    }
}
