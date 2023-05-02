package com.seoultech.blossom.domain.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
