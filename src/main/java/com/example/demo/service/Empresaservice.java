package com.example.demo.service;

import com.example.demo.entity.Empresa;
import com.example.demo.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Empresaservice {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> obtenerTodasLasEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa agregarEmpresa(Empresa empresa) {
        // Aquí puedes realizar validaciones o lógica de negocio antes de guardar en la base de datos
        return empresaRepository.save(empresa);
    }

    public Empresa obtenerEmpresaPorId(String id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        return empresaOptional.orElse(null);
    }

    public Empresa actualizarEmpresa(String id, Empresa empresa) {
        Optional<Empresa> empresaExistenteOptional = empresaRepository.findById(id);
        
        if (empresaExistenteOptional.isPresent()) {
            Empresa empresaExistente = empresaExistenteOptional.get();
            // Actualiza solo los campos necesarios, evitando sobrescribir con valores nulos
            if (empresa.getNombre() != null) {
                empresaExistente.setNombre(empresa.getNombre());
            }
            if (empresa.getDireccion() != null) {
                empresaExistente.setDireccion(empresa.getDireccion());
            }
            if (empresa.getTelefono() != null) {
                empresaExistente.setTelefono(empresa.getTelefono());
            }

            // Guarda la empresa actualizada
            return empresaRepository.save(empresaExistente);
        } else {
            // Manejar el caso donde la empresa no existe
            return null;
        }
    }

    public void eliminarEmpresa(String id) {
        empresaRepository.deleteById(id);
    }
}
