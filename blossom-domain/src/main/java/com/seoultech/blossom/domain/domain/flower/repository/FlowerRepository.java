package com.seoultech.blossom.domain.domain.flower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flower.Flower;

public interface FlowerRepository extends JpaRepository<Flower, Long>, FlowerRepositoryCustom {
}
