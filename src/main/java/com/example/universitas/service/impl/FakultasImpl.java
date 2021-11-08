package com.example.universitas.service.impl;

import com.example.universitas.dto.FakultasModel;
import com.example.universitas.entity.Fakultas;
import com.example.universitas.repository.FakultasRepository;
import com.example.universitas.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FakultasImpl implements FakultasService {

    @Autowired
    public FakultasRepository fakultasRepository;


    @Override
    public Map insert(FakultasModel fakultasModel) {
        Map map = new HashMap();
        try {
            Fakultas fakultas = new Fakultas();
            fakultas.setId(fakultasModel.getId());
            fakultas.setNamaFakultas(fakultasModel.getNamaFakultas());
            fakultas.setKodeFakultas(fakultasModel.getKodeFakultas());
            fakultasRepository.save(fakultas);

            map.put("data", fakultas);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil menambahkan fakultas");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map getAll() {
        Map map = new HashMap();
        List<Fakultas> fakultasList = new ArrayList<Fakultas>();
        try {
            fakultasList = fakultasRepository.getAllFakultas();

            map.put("data", fakultasList);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil menampilkan semua list fakultas");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }
}
