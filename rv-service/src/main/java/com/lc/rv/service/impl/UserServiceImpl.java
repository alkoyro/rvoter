package com.lc.rv.service.impl;

import com.lc.rv.entity.User;
import com.lc.rv.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Alexey.Koyro
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
