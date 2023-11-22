package com.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.Account;
import com.asm.entity.Favorite;

public interface AccountDAO extends JpaRepository<Account, String> {

}
