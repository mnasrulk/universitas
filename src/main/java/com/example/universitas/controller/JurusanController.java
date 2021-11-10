package com.example.universitas.controller;


import com.example.universitas.dto.JurusanModel;
import com.example.universitas.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/jurusan")
public class JurusanController {

    @Autowired
    JurusanService jurusanService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map> getAll() {
        Map map = new HashMap();
        Map jurusanList = jurusanService.getAll();
        return new ResponseEntity<Map>(jurusanList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Map> save(@Valid @RequestBody JurusanModel jurusanModel){
        Map map = new HashMap();
        Map jurusanBaru = jurusanService.insert(jurusanModel);

        map.put("Request = ", jurusanModel);
        map.put("Response = ", jurusanBaru);
        return new ResponseEntity<Map>(jurusanBaru, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@Valid @RequestBody JurusanModel jurusanModel){
        Map map = new HashMap();
        Map updateJurusan = jurusanService.update(jurusanModel);

        map.put("Request = ", jurusanModel);
        map.put("Response = ", updateJurusan);
        return new ResponseEntity<Map>(updateJurusan, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Map> getById(@PathVariable(value= "id") String id){
        Map detailId = jurusanService.getById(id);

        return new ResponseEntity<Map>(detailId, HttpStatus.OK);
    }

    @GetMapping("/count/jurusan")
    public ResponseEntity<Map> getCountJurusanByFakultas(@PathVariable(value= "id") String id){
        Map count = jurusanService.getCountJurusanByFakultas(id);

        return new ResponseEntity<Map>(count, HttpStatus.OK);
    }
}
