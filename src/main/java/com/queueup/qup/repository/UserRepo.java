package com.queueup.qup.repository;

import com.queueup.qup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.email = :email")
    public User getUserByUsername(@Param("email") String email);


    void setEnable(boolean b);
}
