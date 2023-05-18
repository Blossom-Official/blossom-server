package com.seoultech.blossom.domain.domain.flowerlike.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flowerlike.FlowerLike;

public interface FlowerLikeRepository extends JpaRepository<FlowerLike, Long>, FlowerLikeRepositoryCustom {
}
