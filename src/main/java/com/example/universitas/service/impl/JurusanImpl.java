package com.example.universitas.service.impl;


import com.example.universitas.dto.JurusanModel;
import com.example.universitas.entity.Jurusan;
import com.example.universitas.repository.JurusanRepository;
import com.example.universitas.service.JurusanService;
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

    @Override
    public Map insert(JurusanModel jurusanModel) {
        Map map = new HashMap();
        try {
            Jurusan jurusan = new Jurusan();
            jurusan.setId(jurusanModel.getId());
            jurusan.setNamaJurusan(jurusanModel.getNamaJurusan());
            jurusan.setKodeJurusan(jurusanModel.getKodeJurusan());
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
}
