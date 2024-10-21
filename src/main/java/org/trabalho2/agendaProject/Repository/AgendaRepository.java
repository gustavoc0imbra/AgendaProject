package org.trabalho2.agendaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trabalho2.agendaProject.Model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
}
