package com.example.martinhormazabal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.martinhormazabal.model.Resource;

@Repository
public class ResourceRepository {

    private List<Resource> listaRecursos = new ArrayList<>();



    public List<Resource> leerTodos() {
        return listaRecursos;
    }
    
    public Resource guardar(Resource recurso) {
        listaRecursos.add(recurso);
        return recurso;
    }

    public Resource buscarPorId(int id) {
        for (Resource r : listaRecursos) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public Resource buscarPorNombre(String nombre) {
        for (Resource r : listaRecursos) {
            if (r.getNombre().equalsIgnoreCase(nombre)) {
                return r;
            }
        }
        return null;
    }

    public List<Resource> buscarPorTipo(String tipo) {
        List<Resource> resultado = new ArrayList<>();
        for (Resource r : listaRecursos) {
            if (r.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public Resource modificarRecurso(int id, Resource recurso) {
        Resource destino = buscarPorId(id);
        if (destino != null) {
            destino.setNombre(recurso.getNombre());
            destino.setDescripcion(recurso.getDescripcion());
            destino.setDisponible(recurso.isDisponible());
            destino.setResponsable(recurso.getResponsable());
            destino.setFechaCreacion(recurso.getFechaCreacion());
            destino.setTipo(recurso.getTipo());
            destino.setCantidad(recurso.getCantidad());
            return destino;
        }
        return null;
    }

    public boolean eliminarRecurso(int id) {
        return listaRecursos.removeIf(r -> r.getId() == id);
    }

    public List<Resource> ordenarPorCantidadDesc() {
        List<Resource> ordenados = new ArrayList<>(listaRecursos);
        for (int i = 0; i < ordenados.size() - 1; i++) {
            for (int j = i + 1; j < ordenados.size(); j++) {
                if (ordenados.get(i).getCantidad() < ordenados.get(j).getCantidad()) {
                    Resource temp = ordenados.get(i);
                    ordenados.set(i, ordenados.get(j));
                    ordenados.set(j, temp);
                }
            }
        }
        return ordenados;
    }
}