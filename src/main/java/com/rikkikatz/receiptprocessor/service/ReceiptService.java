package com.rikkikatz.receiptprocessor.service;

import org.springframework.stereotype.Service;

import com.rikkikatz.receiptprocessor.model.Receipt;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptService {

    PointsCalculator pointsCalculator = new PointsCalculator();

    private final Map<String, Integer> receiptStore = new HashMap<>();

    public String processReceipt(Receipt receipt) {
        int points = pointsCalculator.calculatePoints(receipt);
        String id = UUID.randomUUID().toString();
        receiptStore.put(id, points);
        return id;
    }

    public Integer getPoints(String id) {
        return receiptStore.get(id);
    }

}
