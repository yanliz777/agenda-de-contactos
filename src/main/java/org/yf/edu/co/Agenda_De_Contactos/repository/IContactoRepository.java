package org.yf.edu.co.Agenda_De_Contactos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yf.edu.co.Agenda_De_Contactos.model.Contacto;

@Repository
public interface IContactoRepository extends JpaRepository<Contacto, Integer> {

}
