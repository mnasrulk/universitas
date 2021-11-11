package com.example.universitas.service.impl;

import com.example.universitas.dto.FakultasModel;
import com.example.universitas.entity.Fakultas;
import com.example.universitas.repository.FakultasRepository;
import com.example.universitas.service.FakultasService;
import com.example.universitas.util.ModelConverter;
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

    @Override
    public Map getById(String id) {
        Map map = new HashMap();
        try {
            Fakultas fakultas = fakultasRepository.getById(id);
            if (fakultas == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data fakultas tidak ada");
                return map;
            }

            map.put("data", fakultas);
            map.put("statusCode", "200");
            map.put("statusMessage", "Data detail fakultas");
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map update(FakultasModel fakultasModel) {
        Map map = new HashMap();
        try {
            Fakultas fakultasExist = fakultasRepository.getById(fakultasModel.getId());

            if (fakultasExist == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data fakultas tidak ada");
                return map;
            }

            fakultasExist.setNamaFakultas(fakultasModel.getNamaFakultas());
            fakultasExist.setKodeFakultas(fakultasModel.getKodeFakultas());

            FakultasModel fakultasModelUpdate = ModelConverter.toFakultasModel(fakultasRepository.save(fakultasExist));

            map.put("data", fakultasModelUpdate);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil update data fakultas");
            return map;
        }  catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }
}
