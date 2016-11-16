/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.model.Item;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jimmy Cook
 */
public class ItemDaoDBImplTest {
    
    private ItemDao testDao;
    
    public ItemDaoDBImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        testDao = (ItemDao) ctx.getBean("itemDao");
        
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("DELETE FROM Items");
    }
    
    @After
    public void tearDown() {
    }
    
    Item[] itemsForTesting = {
        new Item(-1, "Snickers", 1.75, 10),
        new Item(-1, "Chips", 2.75, 45),
        new Item(-1, "PayDay", 0.75, 3454),
        new Item(-1, "Cheese Crackers", 1.15, 12),
        new Item(-1, "Cookies", 1.25, 1),
        new Item(-1, "5th Avenue", 1.20, 0),
    };

    Item[] duplicateItems = {
        new Item(-1, "Snickers", 1.75, 10),
        new Item(-1, "Chips", 2.75, 45),
        new Item(-1, "PayDay", 0.75, 3454),
        new Item(-1, "Cheese Crackers", 1.15, 12),
        new Item(-1, "Cookies", 1.25, 1),
        new Item(-1, "5th Avenue", 1.20, 0),
    };

    Item[] similarItems = {
        new Item(-1, "Mars", 2.75, 3),
        new Item(-1, "M&Ms", 5.70, 8),
        new Item(-1, "Gummy Worms", 12.75, 4),
        new Item(-1, "Sour Patch Kids", 3.15, 0),
        new Item(-1, "Gum", 1.65, 7),
        new Item(-1, "Fastbreak", 1.24, 4),
    };
    
    @Test
    public void testAgainstEmptyDAO() {

        Assert.assertNull("Asking for a non existant item should return null.", testDao.getItemById(445));
        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' is nonzero with empty DAO.", 0, testDao.getAllItems().size());
    }

    @Test
    public void testAddOneItem() {
        Item itemToAdd = itemsForTesting[0];
        testDao.addItem(itemToAdd);

        Assert.assertEquals("Returned item does not match expected.", itemToAdd, testDao.getItemById(itemToAdd.getId()));
        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding one item.", 1, testDao.getAllItems().size());
        Assert.assertTrue("Returned item in getAllItems does not match expected.", testDao.getAllItems().contains(itemToAdd));

    }

    @Test
    public void testUpdateItem() {
        testDao.addItem(itemsForTesting[0]);
        similarItems[0].setId(itemsForTesting[0].getId());
        testDao.updateItem(similarItems[0]);

        Assert.assertEquals("Updated item get does not match expected.", similarItems[0], testDao.getItemById(similarItems[0].getId()));
        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after replacing one item.", 1, testDao.getAllItems().size());
        Assert.assertTrue("Returned item in getAllItems does not match expected.", testDao.getAllItems().contains(similarItems[0]));
    }

    @Test
    public void testAddMultipleItems() {
        for (Item item : itemsForTesting) {
            testDao.addItem(item);
        }

        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding several items.",
                itemsForTesting.length, testDao.getAllItems().size());

        for (int i = 0; i < itemsForTesting.length; i++) {
            Assert.assertEquals("Returned item does not match expected.", itemsForTesting[i], testDao.getItemById(itemsForTesting[i].getId()));
            Assert.assertTrue("Returned item in getAllItems does not match expected.", testDao.getAllItems().contains(itemsForTesting[i]));
        }

    }

    @Test
    public void testUpdateMultipleItems() {
        for (Item item : itemsForTesting) {
            testDao.addItem(item);
        }

        for (int i = 0; i < itemsForTesting.length; i++) {
            similarItems[i].setId(itemsForTesting[i].getId());
            testDao.updateItem(similarItems[i]);
        }

        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after replacing several items.",
                itemsForTesting.length, testDao.getAllItems().size());

        for (int i = 0; i < similarItems.length; i++) {
            Assert.assertEquals("Get item does not match expected return on update.", similarItems[i], testDao.getItemById(similarItems[i].getId()));
            Assert.assertTrue("Returned item in getAllItems does not match expected.", testDao.getAllItems().contains(similarItems[i]));
        }

    }

    @Test
    public void testAddSimilarItems() {
        for (Item item : itemsForTesting) {
            testDao.addItem(item);
        }

        for (Item item : similarItems) {
            testDao.addItem(item);
        }

        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count does not match after adding several similar items.",
                itemsForTesting.length + similarItems.length, testDao.getAllItems().size());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding several similar items.",
                itemsForTesting.length + similarItems.length, testDao.getAllItems().size());

        for (int i = 0; i < similarItems.length; i++) {
            Assert.assertEquals("Get item does not match expected return on addition of similar item.", similarItems[i],
                    testDao.getItemById(similarItems[i].getId()));
            Assert.assertTrue("Returned item in getAllItems does not match expected.", testDao.getAllItems().contains(similarItems[i]));
        }

        for (int i = 0; i < itemsForTesting.length; i++) {
            Assert.assertEquals("Get item does not match expected return on addition of similar item.", itemsForTesting[i],
                    testDao.getItemById(itemsForTesting[i].getId()));
            Assert.assertTrue("Returned item in getAllItems does not match expected.", testDao.getAllItems().contains(itemsForTesting[i]));
        }

    }

    @Test
    public void testAddAndRemoveOneItem() {
        testDao.addItem(itemsForTesting[0]);
        testDao.removeItem(itemsForTesting[0].getId());

        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertNull("Get item should return null after being removed.", testDao.getItemById(itemsForTesting[0].getId()));
        Assert.assertEquals("Expected item count of 'all items' should be zero when adding/removing a single item.", 0, testDao.getAllItems().size());
    }

    @Test
    public void testAddAndRemoveItemTwice() {
        testDao.addItem(itemsForTesting[0]);
        testDao.removeItem(itemsForTesting[0].getId());
        testDao.removeItem(itemsForTesting[0].getId());

        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertNull("Item should return null after being removed.", testDao.getItemById(itemsForTesting[0].getId()));
        Assert.assertEquals("Expected item count of 'all items' should be zero when adding/removing a single item twice.", 0, testDao.getAllItems().size());
    }

    @Test
    public void testAddAndRemoveMultipleItems() {

        for (Item item : itemsForTesting) {
            testDao.addItem(item);
        }

        int itemsAdded = itemsForTesting.length;
        for (int i = 0; i < itemsForTesting.length; i += 2) {
            testDao.removeItem(itemsForTesting[i].getId());
            itemsAdded--;
        }

        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding & removing several items.",
                itemsAdded, testDao.getAllItems().size());

        for (int i = 0; i < itemsForTesting.length; i++) {
            if (i % 2 == 1) {
                Assert.assertEquals("Returned item does not match expected.", itemsForTesting[i], testDao.getItemById(itemsForTesting[i].getId()));
            } else {
                Assert.assertNull("Item should be removed and return null.", testDao.getItemById(itemsForTesting[i].getId()));
            }
        }

    }

    @Test
    public void testAddAndRemoveItemsMultipleTimes() {

        for (Item item : itemsForTesting) {
            testDao.addItem(item);
        }

        for (Item item : itemsForTesting) {
            testDao.removeItem(item.getId());
        }

        for (Item item : itemsForTesting) {
            testDao.addItem(item);
        }

        Assert.assertNotNull("List of all items should not be null.", testDao.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' should be zero when adding/removing a all items.",
                itemsForTesting.length, testDao.getAllItems().size());



        for (int i = 0; i < itemsForTesting.length; i++) {
            Item item = itemsForTesting[i];
            Assert.assertEquals("Item should return after being re-added.", item, testDao.getItemById(item.getId()));
            testDao.removeItem(item.getId());
            Assert.assertNull("Item should return null after being removed.", testDao.getItemById(item.getId()));
        }

        Assert.assertEquals("Expected item count of 'all items' should be zero when adding/removing a all items.", 0, testDao.getAllItems().size());

    }

    @Test
    public void testItemCountOnAddition() {

        // Add all items and check that count increments appropriately
        for (int i = 0; i < itemsForTesting.length; i++) {
            testDao.addItem(itemsForTesting[i]);
            Assert.assertEquals("Expected " + (i + 1) + " items after adding itemses.",
                    i + 1, testDao.getAllItems().size());
        }

    }
    
    @Test
    public void testItemCountOnUpdate() {

        // Add all items and check that count increments appropriately
        for (int i = 0; i < itemsForTesting.length; i++) {
            testDao.addItem(itemsForTesting[i]);
            similarItems[i].setId(itemsForTesting[i].getId());
            testDao.updateItem(similarItems[i]);
            Assert.assertEquals("Expected " + (i + 1) + " items after updating itemses.",
                    i + 1, testDao.getAllItems().size());
        }

    }

    @Test
    public void testItemCountAfterRemoval() {

        // Add all items
        for (int i = 0; i < itemsForTesting.length; i++) {
            testDao.addItem(itemsForTesting[i]);
        }

        // Remove items one by one and test that count decrements properly
        for (int i = 0; i < itemsForTesting.length; i++) {
            testDao.removeItem(itemsForTesting[i].getId());
            Assert.assertEquals("Expected " + (itemsForTesting.length - i - 1) + " items after removing itemses.",
                    itemsForTesting.length - i - 1, testDao.getAllItems().size());
        }
    }

    @Test
    public void testItemsAfterRemovalOfNonExistent() {

        // Add all items
        for (int i = 0; i < itemsForTesting.length; i++) {
            testDao.addItem(itemsForTesting[i]);
        }

        testDao.removeItem(100);
        Assert.assertEquals("Expected " + itemsForTesting.length + " items after removing itemses.",
                itemsForTesting.length, testDao.getAllItems().size());

    }

    @Test
    public void testItemCountAfterTwiceRemoved() {

        // Add all items
        for (int i = 0; i < itemsForTesting.length; i++) {
            testDao.addItem(itemsForTesting[i]);
        }

        // Remove items one by one and test that count decrements properly
        for (int i = 0; i < itemsForTesting.length; i++) {
            testDao.removeItem(itemsForTesting[i].getId());
        }

        Assert.assertEquals("Expected " + 0 + " items after removing itemses.",
                0, testDao.getAllItems().size());

        // Remove items one by one and test that count decrements properly
        for (int i = 0; i < itemsForTesting.length; i++) {
            testDao.removeItem(itemsForTesting[i].getId());
        }

        Assert.assertEquals("Expected " + 0 + " items after attempting to re-remove itemses.",
                0, testDao.getAllItems().size());

    }
    
    
}
