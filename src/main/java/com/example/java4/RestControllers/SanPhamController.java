package com.example.java4.RestControllers;
import com.example.java4.requestStore.SanPhaStore;
import com.example.java4.entitiesLv1.SanPham;
import com.example.java4.repositories.SanPhamRepository;
import com.example.java4.requestUpdate.SanPhaUpdate;
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
@RequestMapping("san-pham")
public class SanPhamController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    SanPhamRepository spRepo;
    public SanPhamController() {
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<SanPham>> index(@RequestParam("page") Optional<Integer> pageParam){
        int page = pageParam.orElse(1);
        Pageable pageale = PageRequest.of(page-1, 20);
        return ResponseEntity.ok(spRepo.findByTrangThai(1,pageale).getContent());
    }

    @CrossOrigin
    @GetMapping("/get-all")
    public ResponseEntity<List<SanPham>> getAll(@RequestParam("page") Optional<Integer> pageParam){
        int page = pageParam.orElse(1);
        Pageable pageale = PageRequest.of(page-1, 20);
        return ResponseEntity.ok(spRepo.findAllByPage(pageale).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(spRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountstt1() {
        return ResponseEntity.ok(spRepo.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountstt0() {
        return ResponseEntity.ok(spRepo.getCountStt0());
    }
    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<SanPham> getDetail(@PathVariable(value = "id") SanPham sanPham){
         return ResponseEntity.ok(sanPham);
    }

    @CrossOrigin
    @PostMapping ("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@RequestBody @Valid SanPhaUpdate newSanPham, BindingResult result,
                                            @PathVariable(value ="id") SanPham sp){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return ResponseEntity.ok(false);
        }
        else{
            sp.setTen(newSanPham.getTen());
            sp.setTrangThai(Integer.valueOf(newSanPham.getTrangThai()));
            sp.setHinhAnh(newSanPham.getHinhAnh());
            sp.setGiaBan(newSanPham.getGiaBan());
            spRepo.save(sp);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(spRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(spRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid SanPhaStore newSanPham,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            LocalDateTime localNow = LocalDateTime.now();
            String ma = "SP"+(spRepo.getCount()+1);
            SanPham sp = new SanPham();
            sp.setTen(newSanPham.getTen());
            sp.setMa(ma);
            sp.setTrangThai(Integer.valueOf(newSanPham.getTrangThai()));
            sp.setNgayTao(localNow);
            sp.setHinhAnh(newSanPham.getHinhAnh());
            sp.setGiaBan(newSanPham.getGiaBan());
            spRepo.save(sp);
            return ResponseEntity.ok(true);
        }
    }
}