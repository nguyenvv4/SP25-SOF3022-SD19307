package com.example.sp25sd19307.controller;

import com.example.sp25sd19307.model.DanhMuc;
import com.example.sp25sd19307.repository.DanhMucRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DanhMucController {

    @Autowired
    DanhMucRepo danhMucRepo;

    @GetMapping("/danh-muc/hien-thi")
    public String hienThi(Model model) {
        List<DanhMuc> list = danhMucRepo.findAll();
        model.addAttribute("list", list);
        return "/ban-hang/san-pham.html";
    }
}
