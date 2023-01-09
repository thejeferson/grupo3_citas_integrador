package Administrador.Administrador.services;

import Administrador.Administrador.entities.Administrador;
import Administrador.Administrador.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService implements IAdministradorService {

    @Autowired
    private AdministradorRepository repository;

    @Override
    public List<Administrador> getAll() {
        return (List<Administrador>) repository.findAll();
    }

    @Override
    public Administrador getById(Long id) {
        return (Administrador) repository.findById(id).get();
    }

    @Override
    public void update(Administrador administrador) {
        repository.save(administrador);
    }


    @Override
    public void  remove(Long id) {
        repository.deleteById(id);
    }


    @Override
    public void save(Administrador administrador) {
        repository.save(administrador);
    }
}
