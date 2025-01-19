package com.example.sp25sd19307.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    // định nghĩa  duong dan home voi phuong thuc GET
    @GetMapping("/home")
    public String home(Model model) {
        System.out.println("Da chay vao day");
        model.addAttribute("att", "Nguyen Van A");
        return "/home.html";
    }
//
//    @PostMapping("/home")
//    public void login(){
//        System.out.println("da chay vao post");
//    }

//    @GetMapping("/login")
//    public String loginForm() {
//        return "/home.html";
//    }
//
//    @PostMapping("/login")
//    public String login(
//            @RequestParam("email") String email,
//            @RequestParam("password") String password,
//            Model model
//    ) {
//        if (email.equals("nguyenvv4") && password.equals("123")) {
//            model.addAttribute("message","Login thanh cong");
//            System.out.println("login thanh cong");
//            return "/kq";
//        } else {
//            model.addAttribute("message","Login khong thanh cong");
//            System.out.println("login khong thanh cong");
//            return "/kq.html";
//        }
//    }

    @GetMapping("/forward")
    public String forward() {
        return "/forward.html";
    }

    @GetMapping("/click")
    public String click(Model model) {
        model.addAttribute("message", "forward");
        return "forward:/forward";
    }

    @GetMapping("/redirect")
    public String redirect(Model model,
                           @RequestParam("message") String mesage) {
        model.addAttribute("message", mesage);
        return "redirect.html";
    }

    @GetMapping("/click/redirect")
    public String clickRedirect(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("message", "redirect");
        return "redirect:/redirect";
    }
}
