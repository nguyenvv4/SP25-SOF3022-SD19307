package com.example.sp25sd19307.repository;

import com.example.sp25sd19307.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, Integer> {

    List<HoaDon> findAllByOrderByNgayTaoDesc();
}
