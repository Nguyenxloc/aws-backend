package com.example.java4.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "SanPham")
public class SanPham {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="Ma")
    private String ma;
    @Column(name ="Ten")
    private String ten;
    @Column(name ="TrangThai")
    private String trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="indx")
    private Integer indx;
}