package com.example.InventoryManagementSystem.repository;

import com.example.InventoryManagementSystem.data.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierRepository {

    private final List<Supplier> suppliers;

    public SupplierRepository(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Supplier add(Supplier supplier) {
        suppliers.add(supplier);
        return supplier;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }
}
