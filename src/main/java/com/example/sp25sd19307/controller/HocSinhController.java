package com.example.sp25sd19307.controller;

import com.example.sp25sd19307.model.HocSinh;
import com.example.sp25sd19307.repository.HocSinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HocSinhController {

    // HocSinhRepo hsrep = new HocSinhRepo();
    @Autowired
    HocSinhRepo hocSinhRepo;

    @GetMapping("/hoc-sinh/hien-thi")
    public String hienThi() {
        List<HocSinh> list = hocSinhRepo.findAll();
        for (HocSinh hs : list) {
            System.out.println(hs.toString());
        }
        return "/home.html";
    }
}
