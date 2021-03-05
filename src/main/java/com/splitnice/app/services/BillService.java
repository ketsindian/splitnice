package com.splitnice.app.services;

import com.splitnice.app.model.*;
import com.splitnice.app.repository.BalanceRepository;
import com.splitnice.app.repository.BillRepository;
import com.splitnice.app.repository.ExpenseRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService implements IBillService {

    private final BillSplitStrategy billSplitStrategy;
    private final BillRepository billRepository;
    private final ExpenseRepository expenseRepository;
    private final BalanceRepository balanceRepository;

    public BillService(BillSplitStrategy billSplitStrategy, BillRepository billRepository, ExpenseRepository expenseRepository, BalanceRepository balanceRepository) {
        this.billSplitStrategy = billSplitStrategy;
        this.billRepository = billRepository;
        this.expenseRepository = expenseRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
//    @Transactional
    public Bill createBill(BillDTO bill) {
        List<Borrower> borrowers=billSplitStrategy.splitAmount(bill.getBorrowers(),bill.getAmount(),bill.getSplit_method());
        Bill billSaved=billRepository.save(bill.getBill());
        List<Expenses> expensesSaved=this.createExpensesFromBill(billSaved,borrowers, bill.getLender());
        this.createBalanceFromExpenses(expensesSaved);
        return billSaved;
    }

    private List<Expenses> createExpensesFromBill(Bill billSaved,List<Borrower> borrowers,User lender){
        List<Expenses> expenses=new ArrayList<>();
        for (Borrower borrower:borrowers){
            Expenses expense=new Expenses();
            expense.setBill(billSaved);
            expense.setAmount(borrower.getSplitAmount());
            expense.setBorrower(borrower.getUser());
            expense.setLender(lender);
            expense.setStatus(EXPENSE_STATUS.UNSETTLED);
            expenses.add(expense);
        }
        return expenseRepository.saveAll(expenses);
    }

    private List<Balance> createBalanceFromExpenses(List<Expenses> expensesSaved){
        List<Balance> balances=new ArrayList<>();
        for (Expenses expense:expensesSaved) {
            Balance balance=new Balance();
            if(expense.getLender().getUser_id()<expense.getBorrower().getUser_id()){
                balance.setUser_borrower(expense.getLender());
                balance.setUser_lender(expense.getBorrower());
                balance.setAmount(-expense.getAmount());
            }else{
                balance.setUser_borrower(expense.getBorrower());
                balance.setUser_lender(expense.getLender());
                balance.setAmount(+expense.getAmount());
            }
            Example<Balance> example = Example.of(balance);
            Balance existingBalance=balanceRepository.getBalance(balance.getUser_borrower().getUser_id(),balance.getUser_lender().getUser_id());
            if(existingBalance!=null){
                balance.setAmount(existingBalance.getAmount()+balance.getAmount());
                balance.setBalance_id(existingBalance.getBalance_id());
                balance.setCreated_ts(existingBalance.getCreated_ts());
            }
            balances.add(balance);
//            User a=expense.getLender().getUser_id()<expense.getBorrower().getUser_id()?expense.getLender():expense.getBorrower();
        }
        return balanceRepository.saveAll(balances);
    }

    @Override
    public List<Bill> getBills() {
        return billRepository.findAll();
    }

    @Override
    public List<Expenses> getExpensesByBill(long billId) {
        return expenseRepository.getExpensesByBillId(billId);
    }
}
