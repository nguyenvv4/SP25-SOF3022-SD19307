package com.example.sp25sd19307.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CtspDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;

    @Column(name = "gia_ban")
    private Double giaBan;

    @Column(name = "ten_mau")
    private String tenMau;

    @Column(name = "ten_size")
    private String tenSize;

    @Override
    public String toString() {
        return "CtspDto{" +
                "id=" + id +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                ", giaBan=" + giaBan +
                ", tenMau='" + tenMau + '\'' +
                ", tenSize='" + tenSize + '\'' +
                '}';
    }
}
