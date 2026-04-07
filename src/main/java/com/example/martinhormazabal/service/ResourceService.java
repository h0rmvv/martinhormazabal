package com.example.martinhormazabal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.martinhormazabal.model.Resource;
import com.example.martinhormazabal.repository.ResourceRepository;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    
    public List<Resource> readAll() {
        return resourceRepository.leerTodos();
    }

    public Resource create(Resource recurso) {
        return resourceRepository.guardar(recurso);
    }

    public Resource readById(int id) {
        return resourceRepository.buscarPorId(id);
    }

    public Resource readByNombre(String nombre) {
        return resourceRepository.buscarPorNombre(nombre);
    }

    public List<Resource> readByTipo(String tipo) {
        return resourceRepository.buscarPorTipo(tipo);
    }

    public Resource updateRecurso(int id, Resource recurso) {
        return resourceRepository.modificarRecurso(id, recurso);
    }

    public boolean delete(int id) {
        return resourceRepository.eliminarRecurso(id);
    }

    public List<Resource> ordenarPorCantidad() {
        return resourceRepository.ordenarPorCantidadDesc();
    }
}