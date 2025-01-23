package com.rikkikatz.receiptprocessor.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rikkikatz.receiptprocessor.model.Item;
import com.rikkikatz.receiptprocessor.model.Receipt;

public class PointsCalculatorTest {

    private PointsCalculator pointsCalculator;

    @BeforeEach
    public void setup() {
        pointsCalculator = new PointsCalculator();
    }


    @Test
    public void testCalculatePoints_AllConditions() {
        Receipt receipt = new Receipt();
        receipt.setRetailer("Retail1"); // +7 letters and numbers
        receipt.setTotal("100.00"); // +50 round dollar +25 multiple of quarter

        List<Item> items = new ArrayList<>();
        Item item1 = new Item();
        item1.setPrice("5.00");
        item1.setShortDescription("foo");
        Item item2 = new Item();
        item2.setPrice("2.00");
        item2.setShortDescription("bars");
        items.add(item1); // +1 (description length is 3 and price is 5: 5*.2 = 1)
        items.add(item2);
        receipt.setItems(items); // +5 for 2 items

        receipt.setPurchaseDate(LocalDate.of(2025, 1, 23)); // +6 odd day
        receipt.setPurchaseTime(LocalTime.of(15, 0)); // +10 between 2 PM and 4 PM

        int points = pointsCalculator.calculatePoints(receipt);
        assertEquals(104, points); // Sum of all conditions (7+50+25+1+5+6+10=104)
    }


}
