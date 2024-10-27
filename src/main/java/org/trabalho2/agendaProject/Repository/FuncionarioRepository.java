package org.trabalho2.agendaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trabalho2.agendaProject.Model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}