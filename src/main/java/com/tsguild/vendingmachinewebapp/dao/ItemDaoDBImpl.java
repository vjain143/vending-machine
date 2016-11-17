/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jimmy Cook
 */
public class ItemDaoDBImpl implements ItemDao {

    private static final String SQL_INSERT_ITEM = 
            "insert into Items (name, cost, quantity) values (?, ?, ?) RETURNING id";
    
    private static final String SQL_DELETE_ITEM =
            "delete from Items where id = ?";
    
    private static final String SQL_SELECT_ITEM = 
            "select * from Items where id = ?";
    
    private static final String SQL_UPDATE_ITEM = 
            "update Items set name = ?, cost = ?, quantity = ? where id = ?";
    
    private static final String SQL_SELECT_ALL_ITEMS =
            "select * from Items";
    
    private static final String SQL_SELECT_ITEMS_BY_NAME = 
            "select * from Items where name = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
            
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Item addItem(Item item) {
        int insertedId = jdbcTemplate.update(SQL_INSERT_ITEM,
                item.getName(),
                item.getCost(),
                item.getQuantity());
        
        item.setId(insertedId);
        
        return item;
    }

    @Override
    public Item getItemById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ITEM, new ItemMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ITEMS, new ItemMapper());
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update(SQL_UPDATE_ITEM,
                item.getName(),
                item.getCost(),
                item.getQuantity(),
                item.getId());
    }

    @Override
    public void removeItem(int id) {
        jdbcTemplate.update(SQL_DELETE_ITEM, id);
    }

    @Override
    public List<Item> searchItemsByName(String name) {
        return jdbcTemplate.query(SQL_SELECT_ITEMS_BY_NAME, new ItemMapper());
    }

    private static final class ItemMapper implements RowMapper<Item> {
        
        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setCost(rs.getDouble("cost"));
            item.setQuantity(rs.getInt("quantity"));
            
            return item;
        }
        
    }
    
}
