package com.example.universitas.service;

import com.example.universitas.dto.FakultasModel;

import java.util.Map;

public interface FakultasService {

    public Map insert(FakultasModel fakultasModel);

    public Map getAll();
}
