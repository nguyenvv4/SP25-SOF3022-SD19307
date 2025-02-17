package com.example.sp25sd19307.controller;

import com.example.sp25sd19307.model.Ctsp;
import com.example.sp25sd19307.repository.CtspRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BanHangController {

    @Autowired
    CtspRepo ctspRepo;

    @GetMapping("/trang-chu")
    public String banHang(Model model) {
        List<Ctsp> list = ctspRepo.findAll();
        model.addAttribute("list", list);
        return "/ban-hang/trang-chu.html";
    }
}
