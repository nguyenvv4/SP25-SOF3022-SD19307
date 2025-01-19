package com.example.sp25sd19307.controller;

import com.example.sp25sd19307.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class UserController {
    // tao ra 1 danh sach user, hien thi danh sach len form
    // cach binding => tao @ModelAttribute ben controller tuong duong voi
    // th:object ben html
    @GetMapping("/user/hien-thi")
    public String hienThi(Model model, @ModelAttribute("user") User user){
        ArrayList<User> listUser = new ArrayList<>();
        listUser.add(new User(1,"Nguyen Van A", 25, "Ha Noi"));
        listUser.add(new User(2,"Nguyen Van B", 20, "Ha Noi"));
        listUser.add(new User(3,"Nguyen Van C", 24, "Ha Noi"));
        listUser.add(new User(4,"Nguyen Van D", 21, "Ha Noi"));
        model.addAttribute("listUser", listUser);
        return "/user.html";
    }

    @PostMapping("/user/save")
    public String save(@Valid @ModelAttribute("user") User user, Errors errors){
        System.out.println(user.toString());
        return "/user.html";
    }
}
