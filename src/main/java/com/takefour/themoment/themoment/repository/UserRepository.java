package com.takefour.themoment.themoment.repository;

import com.takefour.themoment.themoment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserId(String userId);
    User findByUserIdAndPassword(String userId, String password);
}