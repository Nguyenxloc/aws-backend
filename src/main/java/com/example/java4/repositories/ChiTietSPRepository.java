package com.example.java4.repositories;
import com.example.java4.entities.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ChiTietSPRepository
        extends JpaRepository<ChiTietSP,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    Page<ChiTietSP> findByTrangThai(int trangThai, Pageable pageable);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE ChiTietSP ctsp SET ctsp.trangThai = 1 WHERE ctsp.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE ChiTietSP ctsp SET ctsp.trangThai = 0 WHERE ctsp.id=:id")
    int disableStt(@Param("id")String id);
};