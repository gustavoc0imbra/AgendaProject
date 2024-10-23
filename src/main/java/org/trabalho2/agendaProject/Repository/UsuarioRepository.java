package org.trabalho2.agendaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trabalho2.agendaProject.Model.Cliente;
import org.trabalho2.agendaProject.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    int countUsuarioByEmailAndSenha(String email, String senha);
}
