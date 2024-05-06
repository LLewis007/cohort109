package com.lewis.services;

import com.lewis.model.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerUtility {

    public void readCustomersFromCSV() {
        String location = "resources/customers.csv";

        try {
            File file = new File(location);
            Scanner input = new Scanner(file);
            ArrayList<Customer> custList = new ArrayList<Customer>();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] splitedLine = line.split(",");

                Customer cust = new Customer();
                cust.setCustomerNumber(splitedLine[0]);
                cust.setCustomerName(splitedLine[1]);
                cust.setCustomerCity(splitedLine[2]);
                cust.setCustomerState(splitedLine[3]);

                custList.add(cust);
            }

            for (Customer c : custList) {
                System.out.println(c.getCustomerNumber() + " |" + c.getCustomerName() + "| " + c.getCustomerCity() + "|" + c.getCustomerState());
                System.out.println("_______________________________");
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    }



