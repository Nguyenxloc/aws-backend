package com.example.java4.RestControllers;
import com.example.java4.requestStore.HoaDonStore;
import com.example.java4.entities.HoaDon;
import com.example.java4.entitiesNoMap.HoaDonNoMap;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.HoaDonRepoNoMap;
import com.example.java4.requestUpdate.HoaDonUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepository hdRepo;
    @Autowired
    private HoaDonRepoNoMap hoaDonRepoNoMap;
    public HoaDonController() {
    }
    @CrossOrigin
    @GetMapping("index")
    public ResponseEntity<List<HoaDon>> index() {
        return ResponseEntity.ok(hdRepo.findAll());
    }

    @CrossOrigin
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<HoaDon> getDetail(@PathVariable(value = "id") HoaDon hoaDon){
             return ResponseEntity.ok(hoaDon);
    }
    @PostMapping("update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody  @Valid HoaDonUpdate newHoaDon,
            BindingResult result, @PathVariable(value = "id") HoaDonNoMap hd
    ) {
        if (result.hasErrors()){
            System.out.println("tempt error: "+result);
            return ResponseEntity.ok(false);
        }
        else{
            hd.setPttt(newHoaDon.getPttt());
            hd.setIdKhuyenMai(newHoaDon.getIdKhuyenMai());
            hd.setIdNhanVien(newHoaDon.getIdNhanVien());
            hd.setIdKhachHang(newHoaDon.getIdKhachHang());
            hd.setIdGiaoHang(newHoaDon.getIdGiaoHang());
            hd.setNgayTao(Date.valueOf(newHoaDon.getNgayTao()));
            hd.setNgayThanhToan(Date.valueOf(newHoaDon.getNgayThanhToan()));
            hd.setTrangThai(Integer.valueOf(newHoaDon.getTrangThai()));
            hoaDonRepoNoMap.save(hd);
            return  ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(hdRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(hdRepo.enableStt(id));
    }

    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid HoaDonStore newHoaDon,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("temp error: "+ result);
            return ResponseEntity.ok(false);
        }
        else{
            //conduct ma by select count
            HoaDonNoMap hd = new HoaDonNoMap();
            hd.setMa(newHoaDon.getMa());
            hd.setPttt(newHoaDon.getPttt());
            hd.setIdKhuyenMai(newHoaDon.getIdKhuyenMai());
            hd.setIdNhanVien(newHoaDon.getIdNhanVien());
            hd.setIdKhachHang(newHoaDon.getIdKhachHang());
            hd.setIdGiaoHang(newHoaDon.getIdGiaoHang());
            hd.setNgayTao(Date.valueOf(newHoaDon.getNgayTao()));
            hd.setNgayThanhToan(Date.valueOf(newHoaDon.getNgayThanhToan()));
            hd.setTrangThai(Integer.valueOf(newHoaDon.getTrangThai()));
            hoaDonRepoNoMap.save(hd);
            return ResponseEntity.ok(true);
        }
    }
}