package com.example.universitas.repository;


import com.example.universitas.entity.Jurusan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JurusanRepository extends JpaRepository<Jurusan, Long> {

    @Query("select f from Jurusan f")
    public List<Jurusan> getAllJurusan();
}
