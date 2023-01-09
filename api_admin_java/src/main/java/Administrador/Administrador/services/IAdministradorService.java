package Administrador.Administrador.services;

import Administrador.Administrador.entities.Administrador;

import java.util.List;

public interface IAdministradorService {
     List<Administrador> getAll();
    Administrador getById(Long id);

    void update(Administrador administrador);
    void  remove(Long id);

    void save(Administrador administrador);
}
