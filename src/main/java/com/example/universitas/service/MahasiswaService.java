package com.example.universitas.service;

import com.example.universitas.dto.MahasiswaModel;

import java.util.Map;

public interface MahasiswaService {

    public Map getAll();

    public Map getByNpm(String npm);

    public Map insert(MahasiswaModel mahasiswaModel);

    public Map update(MahasiswaModel mahasiswaModel);

    public Map getCountMahasiswaByJurusanId(String jurusan_id);

    public Map getCountMahasiswaByFakultasId(String fakultas_id);
}
