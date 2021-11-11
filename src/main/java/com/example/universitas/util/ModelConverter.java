package com.example.universitas.util;

import com.example.universitas.dto.FakultasModel;
import com.example.universitas.dto.MahasiswaModel;
import com.example.universitas.entity.Fakultas;
import com.example.universitas.entity.Mahasiswa;

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
    }
}
