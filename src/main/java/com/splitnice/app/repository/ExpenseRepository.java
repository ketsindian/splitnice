package com.splitnice.app.repository;

import com.splitnice.app.model.Bill;
import com.splitnice.app.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {

    @Query("select exp from Expenses exp where exp.bill.bill_id=?1")
    public List<Expenses> getExpensesByBillId(long billId);
}
