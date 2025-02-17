package com.example.sp25sd19307.repository;

import com.example.sp25sd19307.model.CtspDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtspDtoRepo extends JpaRepository<CtspDto, Integer> {

    @Query(value = "select ctsp.id, dm.ten_danh_muc, sp.ten_san_pham, ctsp.gia_ban, sc.ten_mau, sz.ten_size from danh_muc dm \n" +
            "join san_pham sp on sp.id_danh_muc = dm.id\n" +
            "join ctsp on ctsp.id_sp = sp.id\n" +
            "join mau_sac sc on ctsp.id_mau_sac = sc.id\n" +
            "join size sz on sz.id = ctsp.id_size",
            nativeQuery = true)
    List<CtspDto> getListCtspDto();

}
