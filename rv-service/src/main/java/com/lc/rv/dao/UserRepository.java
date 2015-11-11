package com.lc.rv.dao;


import com.lc.rv.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * @author Alexey.Koyro
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email LIKE %:emailKey%")
    Page<User> findAllByEmail(Pageable pageable, @Param("emailKey") String emailKey);

}
