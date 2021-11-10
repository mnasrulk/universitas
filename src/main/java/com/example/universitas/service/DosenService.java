package com.example.universitas.service;

import com.example.universitas.dto.DosenModel;

import java.util.Map;

public interface DosenService {

    public Map insert(DosenModel dosenModel);

    public Map getAll();

    public Map getById(String id);

    public Map update(DosenModel dosenModel);

    public Map getCountDosenByFakultasId(String fakultas_id);
}
