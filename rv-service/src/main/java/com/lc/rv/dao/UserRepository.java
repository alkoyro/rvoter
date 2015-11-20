package com.lc.rv.dao;


import com.lc.rv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Alexey.Koyro
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
