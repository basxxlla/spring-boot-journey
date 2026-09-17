package com.example.item.service;

import com.example.item.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAll();
    Optional<Item> getById(Long id);
    Item save(Item item);
    Item update(Long id, Item item);
    void delete(Long id);
}
