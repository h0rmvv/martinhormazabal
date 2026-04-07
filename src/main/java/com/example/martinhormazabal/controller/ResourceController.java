package com.example.martinhormazabal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.martinhormazabal.model.Resource;
import com.example.martinhormazabal.service.ResourceService;

@RestController
@RequestMapping("api/v1/recursos")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    @GetMapping
    public List<Resource> getResources() {
        return resourceService.readAll();
    }

    @PostMapping
    public Resource postResource(@RequestBody Resource resource) {
        return resourceService.create(resource);
    }

    @GetMapping("{id}")
    public Resource getResourcePorId(@PathVariable int id) {
        return resourceService.readById(id);
    }

    @GetMapping("nombre/{nombre}")
    public Resource getResourcePorNombre(@PathVariable String nombre) {
        return resourceService.readByNombre(nombre);
    }

    @GetMapping("tipo/{tipo}")
    public List<Resource> getResourcesPorTipo(@PathVariable String tipo) {
        return resourceService.readByTipo(tipo);
    }

    @GetMapping("ordenar/cantidad")
    public List<Resource> getResourcesOrdenadosPorCantidad() {
        return resourceService.ordenarPorCantidad();
    }

    @PutMapping("{id}")
    public Resource putResource(@PathVariable int id, @RequestBody Resource resource) {
        return resourceService.updateRecurso(id, resource);
    }

    @DeleteMapping("{id}")
    public String deleteResource(@PathVariable int id) {
        if (resourceService.delete(id)) {
            return "Recurso eliminado";
        }
        return "No fue posible eliminar";
    }
}
