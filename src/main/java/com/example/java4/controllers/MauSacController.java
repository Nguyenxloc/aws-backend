package com.example.java4.controllers;
import com.example.java4.dto.mau_sac.StoreRequest;
import com.example.java4.model.MauSac;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
@Controller
@RequestMapping("mau_sac")
public class MauSacController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    ArrayList<MauSac> lstMauSac = new ArrayList<>();
    MauSac msRem = new MauSac();
    public MauSacController() {
        lstMauSac.add(new MauSac("sp1","Black","fdsafasdfs"));
        lstMauSac.add(new MauSac("sp2","Violet","fdsafasdfs"));
        lstMauSac.add(new MauSac("sp3","Yellow","fdsafasdfs"));
        lstMauSac.add(new MauSac("sp4","Pink","fdsafasdfs"));
    }
    @GetMapping("/create")
    public String getSanPhamForm(Model model)
    {
        String name = "SD18203";
        model.addAttribute("lstMauSac",lstMauSac);
        model.addAttribute("data",msRem);
        return "admin/ql_mau_sac/Create";
    }
    @PostMapping("store")
    public String create(
//        @RequestParam("email") Optional<String> username,
//        @RequestParam("password") String pwd,
            @Valid @ModelAttribute("data") StoreRequest req,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("Có lỗi");
        }
        System.out.println(req.getId());
        System.out.println(req.getTen());
        System.out.println(req.getMa());
        MauSac ms = new MauSac(req.getId(),req.getTen(),req.getMa());
        msRem = ms;
        lstMauSac.add(ms);
        System.out.println(result.getAllErrors());
        return "admin/ql_mau_sac/Create";
    }
}