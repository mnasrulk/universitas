package com.example.universitas.util;

import com.example.universitas.dto.FakultasModel;
import com.example.universitas.entity.Fakultas;

public class ModelConverter {

    public static FakultasModel toFakultasModel(Fakultas fakultas){

        FakultasModel fakultasModel = new FakultasModel();
        fakultasModel.setId(fakultas.getId());
        fakultasModel.setNamaFakultas(fakultas.getNamaFakultas());
        fakultasModel.setKodeFakultas(fakultas.getKodeFakultas());

        return fakultasModel;
    }
}
