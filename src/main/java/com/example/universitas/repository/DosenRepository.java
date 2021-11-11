package com.example.universitas.repository;


import com.example.universitas.entity.Dosen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DosenRepository extends JpaRepository<Dosen, String> {

    @Query("select d from Dosen d")
    public List<Dosen> getAllDosen();

    @Query(value = "select * from Dosen WHERE nip = :nip", nativeQuery = true)
    public Dosen getByNip(@Param("nip") String nip);

    @Query(value = "SELECT COUNT(dosen_id) FROM dosen WHERE fakultas_id = :id GROUP BY fakultas_id", nativeQuery = true)
    public String getCountDosenByFakultasId(@Param("id") String id);
}
