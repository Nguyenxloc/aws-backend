package com.example.java4.RestControllers;
import com.example.java4.repositories.ScoreRepository;
import com.example.java4.requestStore.KhachHangStore;
import com.example.java4.entitiesLv1.KhachHang;
import com.example.java4.repositories.KhachHangRepository;
import com.example.java4.requestUpdate.KhachHangUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("score-board")
public class ScoreBoardController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    ScoreRepository scoreRepo;
    public ScoreBoardController() {

    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<KhachHang>> index(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(khRepo.findByTrangThai(1,pageable).getContent()) ;
    }

    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(khRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<KhachHang> getDetail(@PathVariable(value = "id") KhachHang khachHang){
        return ResponseEntity.ok(khachHang);
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid KhachHangStore newKH,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return ResponseEntity.ok(false);
        } else {
            //conduct ma
            LocalDateTime localNow = LocalDateTime.now();
            String ma = "KH"+(khRepo.getCount()+1);
            KhachHang kh = new KhachHang();
            kh.setMa(ma);
            kh.setHoTen(newKH.getHoTen());
            kh.setNgaySinh(newKH.getNgaySinh());
            kh.setSdt(newKH.getSdt());
            kh.setMatKhau(newKH.getMatKhau());
            kh.setTrangThai(Integer.valueOf(newKH.getTrangThai()));
            kh.setNgayTao(localNow);
            khRepo.save(kh);
            return ResponseEntity.ok(true);
        }
    }
}