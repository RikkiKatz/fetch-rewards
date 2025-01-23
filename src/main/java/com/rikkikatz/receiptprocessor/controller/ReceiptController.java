package com.rikkikatz.receiptprocessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonObject;
import com.rikkikatz.receiptprocessor.model.Receipt;
import com.rikkikatz.receiptprocessor.service.ReceiptService;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/process")
    public ResponseEntity<?> processReceipt(@RequestBody Receipt receipt) {
        String id = receiptService.processReceipt(receipt);

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("id", id);

        return ResponseEntity.ok(jsonResponse.toString());
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<?> getPoints(@PathVariable(name= "id") String id) {
        Integer points = receiptService.getPoints(id);        

        if (points == null) {
            return ResponseEntity.notFound().build();
        }

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("points", points);

        return ResponseEntity.ok().body(jsonResponse.toString());
    }
}
