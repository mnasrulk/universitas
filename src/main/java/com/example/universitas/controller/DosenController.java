package com.example.universitas.controller;


import com.example.universitas.dto.DosenModel;
import com.example.universitas.service.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/dosen")
public class DosenController {

    @Autowired
    DosenService dosenService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map> getAll() {
        Map map = new HashMap();
        Map dosenList = dosenService.getAll();
        return new ResponseEntity<Map>(dosenList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Map> save(@Valid @RequestBody DosenModel dosenModel){
        Map map = new HashMap();
        Map dosenBaru = dosenService.insert(dosenModel);

        map.put("Request = ", dosenModel);
        map.put("Response = ", dosenBaru);
        return new ResponseEntity<Map>(dosenBaru, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@Valid @RequestBody DosenModel dosenModel){
        Map map = new HashMap();
        Map updateDosen = dosenService.update(dosenModel);

        map.put("Request = ", dosenModel);
        map.put("Response = ", updateDosen);
        return new ResponseEntity<Map>(updateDosen, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Map> getById(@PathVariable(value= "id") String id){
        Map detailId = dosenService.getById(id);

        return new ResponseEntity<Map>(detailId, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Map> getCountDosenByFakultasId(@PathVariable(value= "id") String id){
        Map count = dosenService.getCountDosenByFakultasId(id);

        return new ResponseEntity<Map>(count, HttpStatus.OK);
    }
}
