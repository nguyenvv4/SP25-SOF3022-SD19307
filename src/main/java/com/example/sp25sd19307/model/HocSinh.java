package com.example.sp25sd19307.model;

import jakarta.persistence.*;
import lombok.Data;

//@Table(name = "hoc_sinh")
//@Entity
//@Data
public class HocSinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "status")
    private String status;

    @Override
    public String toString() {
        return "HocSinh{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
}
