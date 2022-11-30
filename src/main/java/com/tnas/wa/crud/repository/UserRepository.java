package com.tnas.wa.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnas.wa.crud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
