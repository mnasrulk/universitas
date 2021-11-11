package com.example.universitas.service.impl;


import com.example.universitas.dto.DosenModel;
import com.example.universitas.entity.Dosen;
import com.example.universitas.entity.Fakultas;
import com.example.universitas.entity.Jurusan;
import com.example.universitas.repository.DosenRepository;
import com.example.universitas.repository.FakultasRepository;
import com.example.universitas.repository.JurusanRepository;
import com.example.universitas.service.DosenService;
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
public class DosenImpl implements DosenService {

    @Autowired
    public DosenRepository dosenRepository;

    @Autowired
    public JurusanRepository jurusanRepository;

    @Autowired
    public FakultasRepository fakultasRepository;

    @Override
    public Map insert(DosenModel dosenModel) {
        Map map = new HashMap();
        try {
            Fakultas fakultas = fakultasRepository.getById(dosenModel.getFakultasId());
            Jurusan jurusan = jurusanRepository.getById(dosenModel.getJurusanId());

            Dosen dosen = new Dosen();
            dosen.setId(dosenModel.getId());
            dosen.setNamaDosen(dosenModel.getNamaDosen());
            dosen.setNip(dosenModel.getNip());
            dosen.setFakultas(fakultas);
            dosen.setJurusan(jurusan);
            dosenRepository.save(dosen);

            map.put("data", dosen);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil menambahkan dosen");
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
        List<Dosen> dosenList = new ArrayList<Dosen>();
        try {
            dosenList = dosenRepository.getAllDosen();

            map.put("data", dosenList);
            map.put("statusCode", "500");
            map.put("statusMessage", "Berhasil menampilkan semua list dosen");
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
            Dosen dosen = dosenRepository.getById(id);
            if (dosen == null) {
                map.put("statusCode", "404");
                map.put("statusMessage", "Data dosen tidak ada");
                return map;
            }

            map.put("data", dosen);
            map.put("statusCode", "200");
            map.put("statusMessage", "Data item detail");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map update(DosenModel dosenModel) {
        Map map = new HashMap();
        try {
            Dosen dosenExist = dosenRepository.getById(dosenModel.getId());

            if (dosenExist == null) {
                map.put("statusCode", "404");
                map.put("statusMessage", "Data dosen tidak ada");
            }

            Jurusan jurusan = jurusanRepository.getById(dosenModel.getJurusanId());

            if (jurusan == null) {
                map.put("statusCode", "404");
                map.put("statusMessage", "Data jurusan tidak ada");
            }

            Fakultas fakultas = fakultasRepository.getById(jurusan.getFakultas().getId());
            if (fakultas == null) {
                map.put("statusCode", "404");
                map.put("statusMessage", "Data fakultas tidak ada");
            }

            dosenExist.setNamaDosen(dosenModel.getNamaDosen());
            dosenExist.setNip(dosenModel.getNip());
            dosenExist.setFakultas(fakultas);
            dosenExist.setJurusan(jurusan);
            DosenModel dosenModelUpdate = ModelConverter.toDosenModel(dosenRepository.save(dosenExist));

            map.put("data", dosenModelUpdate);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil update data dosen");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map getCountDosenByFakultasId(String fakultas_id) {
        Map map = new HashMap();
        try {
            String dosen = dosenRepository.getCountDosenByFakultasId(fakultas_id);
            if (dosen == null) {
                map.put("statusCode", "404");
                map.put("statusMessage", "Data dosen tidak ada");
            }

            map.put("data", dosen);
            map.put("statusCode", "200");
            map.put("statusMessage", "Jumlah dosen by fakultas_id: ");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "404");
            map.put("statusMessage", e);
            return map;
        }
    }
}
