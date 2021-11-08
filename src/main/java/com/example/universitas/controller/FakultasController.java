package com.example.universitas.controller;

import com.example.universitas.dto.FakultasModel;
import com.example.universitas.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/fakultas")
public class FakultasController {

    @Autowired
    FakultasService fakultasService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map> getAll(){
        Map map = new HashMap();
        Map fakultasList = fakultasService.getAll();
        return new ResponseEntity<Map>(fakultasList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Map> save(@Valid @RequestBody FakultasModel fakultasModel){
        Map map = new HashMap();
        Map fakultasBaru = fakultasService.insert(fakultasModel);

        map.put("Request = ", fakultasModel);
        map.put("Response = ", fakultasBaru);
        return new ResponseEntity<Map>(fakultasBaru, HttpStatus.OK);
    }
}
