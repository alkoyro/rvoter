package com.lc.rv.service.impl;

import com.lc.rv.dao.UserRepository;
import com.lc.rv.entity.User;
import com.lc.rv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alexey.Koyro
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
