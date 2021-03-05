package com.splitnice.app.controller;

import com.splitnice.app.model.*;
import com.splitnice.app.services.IBillService;
import com.splitnice.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BillController {
    private final IBillService billService;

    @Autowired
    public BillController( IBillService billService) {
        this.billService = billService;
    }


    @PostMapping("/bill")
    public Bill createBill(@Validated @RequestBody BillDTO bill) {
        return billService.createBill(bill);
    }

    @GetMapping("/bill")
    public List<Bill> getBills() {
        return billService.getBills();
    }

    @GetMapping("/bill/{billId}/expenses")
    public List<Expenses> getExpensesByBillId(@Validated @PathVariable long billId) {
        return billService.getExpensesByBill(billId);
    }
}
