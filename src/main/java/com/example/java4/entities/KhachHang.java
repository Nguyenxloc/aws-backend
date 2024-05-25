package com.example.java4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "Ma")
    private String ma;
    @Column(name="Ten")
    private String ten;
    @Column(name="TenDem")
    private String tenDem;
    @Column(name="Ho")
    private String ho;
    @Column(name="NgaySinh")
    private String ngaySinh;
    @Column(name="Sdt")
    private String sdt;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name="ThanhPho")
    private String thanhPho;
    @Column(name="QuocGia")
    private String quocGia;
    @Column(name="MatKhau")
    private String matKhau;
    @Column(name="NgayTao")
    private  Date ngayTao;
    @Column(name ="TrangThai")
    private Integer trangThai;
}