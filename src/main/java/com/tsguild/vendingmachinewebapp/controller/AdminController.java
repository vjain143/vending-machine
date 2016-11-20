/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.controller;

import com.tsguild.vendingmachinewebapp.dao.ItemDao;
import com.tsguild.vendingmachinewebapp.model.Item;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Jimmy Cook
 */
@Controller
public class AdminController {
    
    private ItemDao dao;
    
    @Inject
    public AdminController(ItemDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value= "home", method = RequestMethod.GET)
    public String displayHomePage(){
        return "home";
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public Item createItem(@Valid @RequestBody Item item){
        dao.addItem(item);
        return item;
    }
    
    @ResponseBody
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable int id){
        return dao.getItemById(id);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable int id){
        dao.removeItem(id);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
    public void updateItem(@PathVariable int id, @Valid @RequestBody Item item){
        item.setId(id);
        dao.updateItem(item);
    }
    
    @ResponseBody
    @RequestMapping(value = "/allitems", method = RequestMethod.GET)
    public List<Item> getAllItems(){
        return dao.getAllItems();
    }
}
