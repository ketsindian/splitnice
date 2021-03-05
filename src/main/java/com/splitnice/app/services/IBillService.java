package com.splitnice.app.services;

import com.splitnice.app.model.Bill;
import com.splitnice.app.model.BillDTO;
import com.splitnice.app.model.Expenses;
import com.splitnice.app.model.SplitResponse;

import java.util.List;

public interface IBillService {

    public Bill createBill(BillDTO bill);

    public List<Bill> getBills();

    public List<Expenses> getExpensesByBill(long billId);
}
