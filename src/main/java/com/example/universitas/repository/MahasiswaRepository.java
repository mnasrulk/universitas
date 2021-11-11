package com.example.universitas.repository;

import com.example.universitas.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, String> {

    @Query("select m from Mahasiswa m")
    public List<Mahasiswa> getAllMahasiswa();

    @Query(value = "select * from Mahasiswa WHERE npm = :npm", nativeQuery = true)
    public Mahasiswa getByNpm(@Param("npm") String npm);

    @Query(value = "SELECT COUNT(mahasiswa_id) FROM mahasiswa WHERE jurusan_id = :id GROUP BY jurusan_id", nativeQuery = true)
    public String getCountMahasiswaByJurusanId(@Param("id") String id);

    @Query(value = "SELECT COUNT(mahasiswa_id) FROM mahasiswa WHERE fakultas_id = :id GROUP BY fakultas_id", nativeQuery = true)
    public String getCountMahasiswaByFakultasId(@Param("id") String id);
}
