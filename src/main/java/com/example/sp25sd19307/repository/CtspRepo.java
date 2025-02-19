package com.example.sp25sd19307.repository;

import com.example.sp25sd19307.model.Ctsp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtspRepo extends JpaRepository<Ctsp, Integer> {
}
