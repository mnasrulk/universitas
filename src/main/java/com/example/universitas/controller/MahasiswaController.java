package com.example.universitas.controller;

import com.example.universitas.dto.MahasiswaModel;
import com.example.universitas.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

    @Autowired
    MahasiswaService service;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map> getAll(){
        Map map = new HashMap();
        Map mahasiswaList = service.getAll();
        return new ResponseEntity<Map>(mahasiswaList, HttpStatus.OK);
    }

    @GetMapping("/detail/{npm}")
    public ResponseEntity<Map> getByNpm(@PathVariable(value = "npm") String npm){
        Map detailNpm = service.getByNpm(npm);
        return new ResponseEntity<Map>(detailNpm, HttpStatus.OK);
    }
    @GetMapping("/jumlah/{jurusan_id}")
    public ResponseEntity<Map> getCountMahasiswaByJurusan(@PathVariable(value = "jurusan_id") String jurusan_id){
        Map hasilCount = service.getCountMahasiswaByJurusanId(jurusan_id);
        return new ResponseEntity<Map>(hasilCount, HttpStatus.OK);
    }

    @GetMapping("/jumlah/fakultas/{fakultas_id}")
    public ResponseEntity<Map> getCountMahasiswaByFakultas(@PathVariable(value = "fakultas_id") String fakultas_id){
        Map hasilCount = service.getCountMahasiswaByFakultasId(fakultas_id);
        return new ResponseEntity<Map>(hasilCount, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Map> save(@Valid @RequestBody MahasiswaModel mahasiswaModel){
        Map map = new HashMap();
        Map mahasiswaBaru = service.insert(mahasiswaModel);

        map.put("Request = ", mahasiswaModel);
        map.put("Response = ", mahasiswaBaru);
        return new ResponseEntity<Map>(mahasiswaBaru, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@Valid @RequestBody MahasiswaModel mahasiswaModel){
        Map map = new HashMap();
        Map updateMahasiswa = service.update(mahasiswaModel);

        map.put("Request = ", mahasiswaModel);
        map.put("Response = ", updateMahasiswa);
        return new ResponseEntity<Map>(updateMahasiswa, HttpStatus.OK);
    }
}
