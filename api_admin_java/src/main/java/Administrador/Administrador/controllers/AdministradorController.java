package Administrador.Administrador.controllers;

import Administrador.Administrador.entities.Administrador;
import Administrador.Administrador.services.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AdministradorController {

    @Autowired
    private IAdministradorService service;

    @GetMapping("/api/administradores")
    public List<Administrador> getAll() {
       return service.getAll();
    }

    @GetMapping ("/api/administradores/{id}")
    public Administrador getById(@PathVariable String id) {
        return service.getById(Long.parseLong(id));
    }

    @PutMapping( "/api/administradores")
    public void update(@RequestBody Administrador administrador) {
        service.update(administrador);
    }


    @DeleteMapping("/api/administradores/{id}")
    public void  remove(@PathVariable String id) {
        service.remove(Long.parseLong(id));
    }

    @PostMapping  ( "/api/administradores")
    public void save(@RequestBody Administrador administrador) {
        service.save(administrador);
    }


}
