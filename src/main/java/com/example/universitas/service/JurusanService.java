package com.example.universitas.service;


import com.example.universitas.dto.JurusanModel;

import java.util.Map;

public interface JurusanService {

    public Map insert(JurusanModel jurusanModel);

    public Map getAll();

    public Map getById(String id);

    public Map update(JurusanModel jurusanModel);

    public Map getCountJurusanByFakultasId(String fakultas_id);
}
