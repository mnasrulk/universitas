package com.example.universitas.util;

import com.example.universitas.dto.DosenModel;
import com.example.universitas.dto.FakultasModel;
import com.example.universitas.dto.MahasiswaModel;
import com.example.universitas.entity.Fakultas;
import com.example.universitas.entity.Mahasiswa;
import com.example.universitas.dto.JurusanModel;
import com.example.universitas.entity.Dosen;
import com.example.universitas.entity.Fakultas;
import com.example.universitas.entity.Jurusan;

public class ModelConverter {

    public static FakultasModel toFakultasModel(Fakultas fakultas){

        FakultasModel fakultasModel = new FakultasModel();
        fakultasModel.setId(fakultas.getId());
        fakultasModel.setNamaFakultas(fakultas.getNamaFakultas());
        fakultasModel.setKodeFakultas(fakultas.getKodeFakultas());

        return fakultasModel;
    }

    public static MahasiswaModel toMahasiswaModel(Mahasiswa mahasiswa){

        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        mahasiswaModel.setId(mahasiswa.getId());
        mahasiswaModel.setNamaMahasiswa(mahasiswa.getNamaMahasiswa());
        mahasiswaModel.setNpm(mahasiswa.getNpm());
        mahasiswaModel.setJurusanId(mahasiswa.getJurusan().getId());

        return mahasiswaModel;
      
    public static JurusanModel toJurusanModel(Jurusan jurusan){
        JurusanModel jurusanModel = new JurusanModel();
        jurusanModel.setId(jurusan.getId());
        jurusanModel.setNamaJurusan(jurusan.getNamaJurusan());
        jurusanModel.setKodeJurusan(jurusan.getKodeJurusan());

        return jurusanModel;
    }

    public static DosenModel toDosenModel(Dosen dosen){
        DosenModel dosenModel = new DosenModel();
        dosenModel.setId(dosen.getId());
        dosenModel.setNamaDosen(dosen.getNamaDosen());
        dosenModel.setNip(dosen.getNip());

        return dosenModel;
    }
}
