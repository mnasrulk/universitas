package com.example.universitas.service.impl;

import com.example.universitas.dto.MahasiswaModel;
import com.example.universitas.entity.Fakultas;
import com.example.universitas.entity.Jurusan;
import com.example.universitas.entity.Mahasiswa;
import com.example.universitas.repository.FakultasRepository;
import com.example.universitas.repository.JurusanRepository;
import com.example.universitas.repository.MahasiswaRepository;
import com.example.universitas.service.MahasiswaService;
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
public class MahasiswaImpl implements MahasiswaService {

    @Autowired
    public MahasiswaRepository mahasiswaRepository;

    @Autowired
    public FakultasRepository fakultasRepository;

    @Autowired
    public JurusanRepository jurusanRepository;

    @Override
    public Map getAll() {
        Map map = new HashMap();
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();
        try {
            mahasiswaList = mahasiswaRepository.getAllMahasiswa();

            map.put("data", mahasiswaList);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil menampilkan semua list mahasiswa");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map getByNpm(String npm) {
        Map map = new HashMap();
        try {
            Mahasiswa mahasiswa = mahasiswaRepository.getByNpm(npm);
            if (mahasiswa == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data mahasiswa tidak ada");
                return map;
            }

            map.put("data", mahasiswa);
            map.put("statusCode", "200");
            map.put("statusMessage", "Data mahasiswa by npm");
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map insert(MahasiswaModel mahasiswaModel) {
        Map map = new HashMap();
        try {
            Jurusan jurusan = jurusanRepository.getById(mahasiswaModel.getJurusanId());
            if (jurusan == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data jurusan tidak ada");
            }

            Fakultas fakultas = fakultasRepository.getById(jurusan.getFakultas().getId());
            if (fakultas == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data fakultas tidak ada");
                return map;
            }

            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setId(mahasiswaModel.getId());
            mahasiswa.setNamaMahasiswa(mahasiswaModel.getNamaMahasiswa());
            mahasiswa.setNpm(mahasiswaModel.getNpm());
            mahasiswa.setFakultas(fakultas);
            mahasiswa.setJurusan(jurusan);
            mahasiswaRepository.save(mahasiswa);

            map.put("data", mahasiswa);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil menambahkan mahasiswa");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map update(MahasiswaModel mahasiswaModel) {
        Map map = new HashMap();
        try {
            Mahasiswa mahasiswaExist = mahasiswaRepository.getById(mahasiswaModel.getId());

            if (mahasiswaExist == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data mahasiswa tidak ada");
                return map;
            }

            Jurusan jurusan = jurusanRepository.getById(mahasiswaModel.getJurusanId());
            if (jurusan == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data jurusan tidak ada");
            }

            Fakultas fakultas = fakultasRepository.getById(jurusan.getFakultas().getId());
            if (fakultas == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data fakultas tidak ada");
                return map;
            }

            mahasiswaExist.setNamaMahasiswa(mahasiswaModel.getNamaMahasiswa());
            mahasiswaExist.setNpm(mahasiswaModel.getNpm());
            mahasiswaExist.setFakultas(fakultas);
            mahasiswaExist.setJurusan(jurusan);

            MahasiswaModel updateMahasiswa = ModelConverter.toMahasiswaModel(mahasiswaRepository.save(mahasiswaExist));

            map.put("data", updateMahasiswa);
            map.put("statusCode", "200");
            map.put("statusMessage", "Berhasil update item");
            return map;
        }  catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map getCountMahasiswaByJurusanId(String jurusan_id) {
        Map map = new HashMap();
        try {
            String mahasiswa = mahasiswaRepository.getCountMahasiswaByJurusanId(jurusan_id);
            if (mahasiswa == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data mahasiswa tidak ada");
                return map;
            }

            map.put("data", mahasiswa);
            map.put("statusCode", "200");
            map.put("statusMessage", "Jumlah mahasiswa by jurusan_id");
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map getCountMahasiswaByFakultasId(String fakultas_id) {
        Map map = new HashMap();
        try {
            String mahasiswa = mahasiswaRepository.getCountMahasiswaByFakultasId(fakultas_id);
            if (mahasiswa == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data mahasiswa tidak ada");
                return map;
            }

            map.put("data", mahasiswa);
            map.put("statusCode", "200");
            map.put("statusMessage", "Jumlah mahasiswa by fakultas_id");
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }
}
