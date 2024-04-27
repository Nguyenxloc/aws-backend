package com.example.java4.viewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HDCTfullView {
    private Integer id;
    private String idHoaDon;
    private String IdSPCT;
    private int soLuong;
    private int donGia;
    private Date ngayThanhToan;
    private Time thoiGian;
    private Integer trangThai;
}