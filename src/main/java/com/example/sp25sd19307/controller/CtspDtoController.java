package com.example.sp25sd19307.controller;

import com.example.sp25sd19307.model.Ctsp;
import com.example.sp25sd19307.model.CtspDto;
import com.example.sp25sd19307.repository.CtspDtoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CtspDtoController {

    @Autowired
    CtspDtoRepo ctspDtoRepo;

    @GetMapping("/ctsp-dto")
    public String ctspDto(Model model) {
        List<CtspDto> list = ctspDtoRepo.getListCtspDto();
        for (CtspDto ctspDto :list){
            System.out.println(ctspDto.toString());
        }
        return "";
    }
}
