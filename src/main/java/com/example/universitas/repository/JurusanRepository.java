package com.example.universitas.repository;


import com.example.universitas.entity.Jurusan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JurusanRepository extends JpaRepository<Jurusan, String> {

    @Query("select f from Jurusan f")
    public List<Jurusan> getAllJurusan();

    @Query(value = "select * from Jurusan WHERE jurusan_id = :id", nativeQuery = true)
    public Jurusan getById(@Param("id") String id);

    @Query(value = "select count(namaJurusan) from Jurusan WHERE fakultas_id= :id GROUP BY fakultas_id", nativeQuery = true)
    public Jurusan getCountJurusanByFakultasId(@Param("id") String id);
}
