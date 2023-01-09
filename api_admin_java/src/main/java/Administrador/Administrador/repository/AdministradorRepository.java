package Administrador.Administrador.repository;

import Administrador.Administrador.entities.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
}
