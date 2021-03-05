package com.splitnice.app.services;

import com.splitnice.app.model.Borrower;
import com.splitnice.app.model.EXPENSE_STRATEGY;
import com.splitnice.app.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillSplitStrategy {
    public List<Borrower> splitAmount(List<Borrower> borrowers, long  totalAmount, EXPENSE_STRATEGY billSplitStrategy){
        if(billSplitStrategy.equals(EXPENSE_STRATEGY.EQUALLY)){
            int totalUsers=borrowers.size();
            for (Borrower user:borrowers ) {
                user.setSplitAmount(totalAmount/totalUsers);
            }
        }
        return borrowers;
    };
}
