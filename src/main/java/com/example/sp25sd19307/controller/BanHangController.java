package com.example.sp25sd19307.controller;

import com.example.sp25sd19307.model.*;
import com.example.sp25sd19307.repository.CtspRepo;
import com.example.sp25sd19307.repository.HdctRepo;
import com.example.sp25sd19307.repository.HoaDonRepo;
import com.example.sp25sd19307.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class BanHangController {

    @Autowired
    CtspRepo ctspRepo;

    @Autowired
    HdctRepo hdctRepo;

    @Autowired
    HoaDonRepo hoaDonRepo;

    @Autowired
    KhachHangRepo khachHangRepo;


    @GetMapping("/trang-chu")
    public String banHang(Model model) {
        // danh sach ctsp
        List<Ctsp> list = ctspRepo.findAll();
        model.addAttribute("list", list);
        // danh sach hoa don
        List<HoaDon> listHoaDon = hoaDonRepo.findAllByOrderByNgayTaoDesc();
        model.addAttribute("listHoaDon", listHoaDon);
        List<KhachHang> listKhachHang = khachHangRepo.findAll();
        model.addAttribute("listKhachHang", listKhachHang);

        return "/ban-hang/ban-hang.html";
    }

    @GetMapping("/them-gio-hang")
    public String themGioHang(Model model,
                              @RequestParam("idCtsp") Integer idCtsp,
                              @RequestParam("soLuong") Integer soLuong) {
        // lay ctsp theo idctsp
        Ctsp ctsp = ctspRepo.findById(idCtsp).get();
        if (ctsp.getSoLuongTon() < soLuong) {
            // khong hop le
        } else {
            // tao hoa don chi tiet cho hoa don 1
            Hdct hdct = new Hdct();

            hdct.setGiaBan(ctsp.getGiaBan());
            hdct.setNgayTao(new Date());
            HoaDon hoaDon = new HoaDon();
            hoaDon.setId(1);
            hdct.setIdHoaDon(hoaDon);
            hdct.setSoLuongMua(soLuong);
            hdct.setTongTien(soLuong * ctsp.getGiaBan());
            hdct.setTrangThai("thanh cong");
            hdctRepo.save(hdct);
        }

        // kiem tra so luong co hop le hay khong

        // khi so luong hop le => insert vao bang hoa don chi tiet

        return "/ban-hang/ban-hang.html";
    }

    @GetMapping("/hoa-don/add")
    public String taoHoaDon(Model model) {
        HoaDon hoaDon = new HoaDon();
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(1);
        hoaDon.setIdNhanVien(nhanVien);
        hoaDon.setNgayTao(new Date());
        hoaDon.setNgaySua(new Date());
        hoaDon.setTrangThai("chua thanh toan");
        hoaDonRepo.save(hoaDon);
        return "redirect:/trang-chu";
    }

    @GetMapping("/chon-hoa-don/${id}")
    public String chonHoaDon(Model model,
                             @PathVariable Integer id) {
        model.addAttribute("id", id);
        List<Hdct> hdctList = hdctRepo.findAll();
        model.addAttribute("hdctList", hdctList);
        return "/ban-hang/ban-hang.html";
    }
}
