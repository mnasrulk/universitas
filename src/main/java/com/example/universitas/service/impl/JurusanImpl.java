package com.example.universitas.service.impl;


import com.example.universitas.dto.JurusanModel;
import com.example.universitas.entity.Fakultas;
import com.example.universitas.entity.Jurusan;
import com.example.universitas.repository.FakultasRepository;
import com.example.universitas.repository.JurusanRepository;
import com.example.universitas.service.JurusanService;
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
public class JurusanImpl implements JurusanService {

    @Autowired
    public JurusanRepository jurusanRepository;

    @Autowired
    public FakultasRepository fakultasRepository;

    @Override
    public Map insert(JurusanModel jurusanModel) {
        Map map = new HashMap();
        try {
            Fakultas fakultas = fakultasRepository.getById(jurusanModel.getFakultasId());

            Jurusan jurusan = new Jurusan();
            jurusan.setId(jurusanModel.getId());
            jurusan.setNamaJurusan(jurusanModel.getNamaJurusan());
            jurusan.setKodeJurusan(jurusanModel.getKodeJurusan());
            jurusan.setFakultas(fakultas);
            jurusanRepository.save(jurusan);

            map.put("data", jurusan);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil menambahkan jurusan");
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
        List<Jurusan> jurusanList = new ArrayList<Jurusan>();
        try {
            jurusanList = jurusanRepository.getAllJurusan();

            map.put("data", jurusanList);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil menampilkan semua list jurusan");
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
            Jurusan jurusan = jurusanRepository.getById(id);
            if (jurusan == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data jurusan tidak ada");
                return map;
            }

            map.put("data", jurusan);
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
    public Map update(JurusanModel jurusanModel) {
        Map map = new HashMap();
        try {
            Jurusan jurusanExist = jurusanRepository.getById(jurusanModel.getId());

            if (jurusanExist == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data jurusan tidak ada");
                return map;
            }

            Fakultas fakultas = fakultasRepository.getById(jurusanModel.getFakultasId());

            if (fakultas == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data Fakultas tidak ada");
                return map;
            }

            jurusanExist.setNamaJurusan(jurusanModel.getNamaJurusan());
            jurusanExist.setKodeJurusan(jurusanModel.getKodeJurusan());
            jurusanExist.setFakultas(fakultas);
            JurusanModel jurusanModelUpdate = ModelConverter.toJurusanModel(jurusanRepository.save(jurusanExist));

            map.put("data", jurusanModelUpdate);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil update data jurusan");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map getCountJurusanByFakultas(String fakultas_id) {
        Map map = new HashMap();
        try {
            Jurusan jurusan = jurusanRepository.getCountJurusanByFakultasId(fakultas_id);
            if (jurusan == null) {
                map.put("statusCode", "404");
                map.put("statusMessage", "Data jurusan tidak ada");
            }

            map.put("data", jurusan);
            map.put("statusCode", "200");
            map.put("statusMessage", "Jumlah jurusan by fakultas_id: ");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "404");
            map.put("statusMessage", e);
            return map;
        }
    }
}
