package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.User1;

public interface CustomerDAO extends JpaRepository<User1,Integer> {

}
