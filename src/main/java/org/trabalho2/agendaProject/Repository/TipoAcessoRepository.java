package org.trabalho2.agendaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trabalho2.agendaProject.Model.TipoAcesso;

@Repository
public interface TipoAcessoRepository extends JpaRepository<TipoAcesso, Integer> {
}
