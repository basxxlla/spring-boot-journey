package com.example.item.controller;

import com.example.item.model.Item;
import com.example.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // 3. Show All Items
    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("items", itemService.getAll());
        return "item-list";
    }

    // 5. Show Item By ID
    @GetMapping("/{id}")
    public String showById(@PathVariable Long id, Model model) {
        Item item = itemService.getById(id)
                .orElseThrow(() -> new javax.persistence.EntityNotFoundException("Item not found with id: " + id));
        model.addAttribute("item", item);
        return "item-details";
    }

    // 1. Add Item - show empty form
    @GetMapping("/new")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "item-form";
    }

    // 1. Add Item - handle submit
    @PostMapping
    public String addItem(@Valid @ModelAttribute("item") Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item-form";
        }
        itemService.save(item);
        return "redirect:/items";
    }

    // 4. Update Item - show pre-filled form
    @GetMapping("/{id}/edit")
    public String editItemForm(@PathVariable Long id, Model model) {
        Item item = itemService.getById(id)
                .orElseThrow(() -> new javax.persistence.EntityNotFoundException("Item not found with id: " + id));
        model.addAttribute("item", item);
        return "item-form";
    }

    // 4. Update Item - handle submit
    @PostMapping("/{id}")
    public String updateItem(@PathVariable Long id, @Valid @ModelAttribute("item") Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item-form";
        }
        itemService.update(id, item);
        return "redirect:/items";
    }

    // 2. Delete Item
    @PostMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return "redirect:/items";
    }
}
