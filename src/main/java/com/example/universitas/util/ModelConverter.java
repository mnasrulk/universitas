package com.example.universitas.util;

import com.example.universitas.dto.FakultasModel;
import com.example.universitas.dto.JurusanModel;
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

    public static JurusanModel toJurusanModel(Jurusan jurusan){
        JurusanModel jurusanModel = new JurusanModel();
        jurusanModel.setId(jurusan.getId());
        jurusanModel.setNamaJurusan(jurusan.getNamaJurusan());
        jurusanModel.setKodeJurusan(jurusan.getKodeJurusan());

        return jurusanModel;
    }
}
