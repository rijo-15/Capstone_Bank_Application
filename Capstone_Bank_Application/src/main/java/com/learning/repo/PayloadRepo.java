package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Payload;

public interface PayloadRepo extends JpaRepository<Payload, Long> {

}
