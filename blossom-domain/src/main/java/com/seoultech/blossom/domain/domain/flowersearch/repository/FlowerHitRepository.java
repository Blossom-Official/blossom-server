package com.seoultech.blossom.domain.domain.flowersearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flowersearch.FlowerHit;

public interface FlowerHitRepository extends JpaRepository<FlowerHit, Long>, FlowerHitRepositoryCustom {
}
