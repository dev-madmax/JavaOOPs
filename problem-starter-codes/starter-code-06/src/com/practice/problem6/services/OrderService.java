package com.practice.problem6.services;

import com.practice.problem6.models.*;
import com.practice.problem6.exceptions.*;

/**
 * Provides order management operations.
 */
public class OrderService {
    /**
     * Construct service.
     */
    public OrderService() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add customer to system.
     * @param customer customer to add
     */
    public void addCustomer(Customer customer) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove customer.
     * @param customerId id to remove
     */
    public void removeCustomer(int customerId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add menu item.
     * @param item menu item to add
     */
    public void addMenuItem(MenuItem item) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove menu item.
     * @param itemName name to remove
     */
    public void removeMenuItem(String itemName) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Place order for customer with items.
     * @param customerId customer id
     * @param items item names
     * @return order object
     */
    public Order placeOrder(int customerId, String[] items) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove order by id.
     * @param orderId unique order id
     */
    public void removeOrder(String orderId) {
        throw new UnsupportedOperationException("TODO");
    }
}