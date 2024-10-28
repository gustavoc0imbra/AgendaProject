package org.trabalho2.agendaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.trabalho2.agendaProject.Model.Agenda;

import java.util.Date;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
    @Query("SELECT count(a) FROM Agenda a WHERE a.data = :data")
    public int countAgendaByData (Date data);
}
