package com.splitnice.app.services;

import com.splitnice.app.model.Balance;
import com.splitnice.app.model.User;
import com.splitnice.app.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService implements IBalanceService{


    private BalanceRepository balanceRepository;

    @Autowired
    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public List<Balance> getBalances(long userId) {
        return balanceRepository.getUserBalances(userId);
    }
}
