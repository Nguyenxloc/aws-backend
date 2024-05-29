package com.example.java4.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "giaohang")
public class GiaoHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="HoTen")
    private String hoTen;
    @Column(name="Sdt")
    private String sdt;
    @Column(name = "diachi")
    private String diaChi;
    @ManyToOne
    @JoinColumn(name="IdPhuongXa",referencedColumnName = "id")
    private PhuongXa phuongXa;
    @ManyToOne
    @JoinColumn(name="IdQuanHuyen", referencedColumnName = "id")
    private QuanHuyen quanHuyen;
    @ManyToOne
    @JoinColumn(name="IdTinhThanh",referencedColumnName = "Id")
    private TinhThanh tinhThanh;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
}
