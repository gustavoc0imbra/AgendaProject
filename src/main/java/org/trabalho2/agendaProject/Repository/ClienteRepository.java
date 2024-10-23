package org.trabalho2.agendaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.trabalho2.agendaProject.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
