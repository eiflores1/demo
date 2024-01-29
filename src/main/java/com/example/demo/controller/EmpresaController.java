package com.example.demo.controller;

import com.example.demo.entity.Empresa;
import com.example.demo.service.Empresaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private Empresaservice empresaservice;

    @GetMapping
    public List<Empresa> obtenerEmpresas() {
        return empresaservice.obtenerTodasLasEmpresas();
    }

    @PostMapping
    public Empresa agregarEmpresa(@RequestBody Empresa empresa) {
        return empresaservice.agregarEmpresa(empresa);
    }

    @GetMapping("/{id}")
    public Empresa obtenerEmpresaPorId(@PathVariable String id) {
        return empresaservice.obtenerEmpresaPorId(id);
    }

    @PutMapping("/{id}")
    public Empresa actualizarEmpresa(@PathVariable String id, @RequestBody Empresa empresa) {
        return empresaservice.actualizarEmpresa(id, empresa);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable String id) {
        empresaservice.eliminarEmpresa(id);
    }
}

