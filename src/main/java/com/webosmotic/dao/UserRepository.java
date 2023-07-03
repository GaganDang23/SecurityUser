package com.webosmotic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webosmotic.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
