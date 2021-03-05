package com.splitnice.app.repository;

import com.splitnice.app.model.Balance;
import com.splitnice.app.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

    @Query("select bl from Balance bl where bl.user_borrower.user_id=?1 and bl.user_lender.user_id=?2")
    public Balance getBalance(long borrower_id,long lender_id);

    @Query("select bl from Balance bl where bl.user_lender.user_id=?1 or bl.user_borrower.user_id=?1")
    public List<Balance> getUserBalances(long userId);
}
