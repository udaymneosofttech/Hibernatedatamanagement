package com.bigfm.com.BigFmDataManagement.repository;

import com.bigfm.com.BigFmDataManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
