package com.splitnice.app.services;


import com.splitnice.app.model.Balance;
import com.splitnice.app.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    public User getUserById(long userId);

    public User createUser(User user);

    public List<User> getUsers();

    public List<Balance> getUserBalance(long userId);
}
