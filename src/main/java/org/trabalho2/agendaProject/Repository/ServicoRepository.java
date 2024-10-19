package org.trabalho2.agendaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trabalho2.agendaProject.Model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}