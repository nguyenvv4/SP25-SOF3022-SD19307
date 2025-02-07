package com.example.sp25sd19307.controller;

import com.example.sp25sd19307.model.HocSinh;
import com.example.sp25sd19307.repository.HocSinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HocSinhController {

    // HocSinhRepo hsrep = new HocSinhRepo();
    @Autowired
    HocSinhRepo hocSinhRepo;

    @GetMapping("/hoc-sinh/hien-thi")
    public String hienThi(Model model) {
        List<HocSinh> list = hocSinhRepo.findAll();
        model.addAttribute("list", list);
        return "/hoc-sinh/hoc-sinh.html";
    }

//    @PostMapping("/hoc-sinh/add")
//    public String add(@ModelAttribute("hocSinh") HocSinh hocSinh) {
//        hocSinhRepo.save(hocSinh);
//        return "redirect:/hoc-sinh/hien-thi";
//    }

    @GetMapping("/hoc-sinh/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        hocSinhRepo.deleteById(id);
        return "redirect:/hoc-sinh/hien-thi";

    }

    @GetMapping("/hoc-sinh/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        HocSinh hocSinh = hocSinhRepo.findById(id).get();
        model.addAttribute("hocSinh", hocSinh);
        return "/hoc-sinh/detail.html";

    }

    @PostMapping("/hoc-sinh/add")
    public String add(HocSinh hocSinh) {
        hocSinhRepo.save(hocSinh);
        return "redirect:/hoc-sinh/hien-thi";
    }

    @PostMapping("/hoc-sinh/update/{id}")
    public String update(HocSinh hocSinh) {
        hocSinhRepo.save(hocSinh);
        return "redirect:/hoc-sinh/hien-thi";
    }


}
