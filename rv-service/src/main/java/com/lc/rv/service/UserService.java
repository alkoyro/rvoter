package com.lc.rv.service;

import com.lc.rv.entity.User;

/**
 * @author Alexey.Koyro
 */
public interface UserService {
    User findByUsername(String username);
}
