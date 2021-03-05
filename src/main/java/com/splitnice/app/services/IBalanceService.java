package com.splitnice.app.services;

import com.splitnice.app.model.Balance;
import com.splitnice.app.model.BillDTO;
import com.splitnice.app.model.SplitResponse;
import com.splitnice.app.model.User;

import java.util.List;

public interface IBalanceService {

    public List<Balance> getBalances(long userId);
}
