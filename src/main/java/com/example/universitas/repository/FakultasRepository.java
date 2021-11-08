package com.example.universitas.repository;

import com.example.universitas.entity.Fakultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FakultasRepository extends JpaRepository<Fakultas, Long> {

    @Query("select f from Fakultas f")
    public List<Fakultas> getAllFakultas();
}
