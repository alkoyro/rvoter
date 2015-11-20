package com.lc.rv.service;

import com.lc.rv.entity.User;

/**
 * @author Alexey.Koyro
 */
public interface UserService {
    User findByLogin(String username);
}
