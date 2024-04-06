package com.example.InventoryManagementSystem.repository;

import com.example.InventoryManagementSystem.data.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    private final List<Item> items;

    public ItemRepository(List<Item> items) {
        this.items = items;
    }

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public List<Item> getItems() {
        return items;
    }
}
