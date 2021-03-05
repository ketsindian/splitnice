package com.splitnice.app.services;

import com.splitnice.app.model.Balance;
import com.splitnice.app.model.User;
import com.splitnice.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final IBalanceService balanceService;

    @Autowired
    public UserService(UserRepository userRepository, IBalanceService balanceService) {
        this.userRepository = userRepository;
        this.balanceService = balanceService;
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Balance> getUserBalance(long userId) {
        return balanceService.getBalances(userId);
    }
}
