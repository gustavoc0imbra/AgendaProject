package org.trabalho2.agendaProject.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trabalho2.agendaProject.Enum.TipoAcessoEnum;
import org.trabalho2.agendaProject.Model.Usuario;
import org.trabalho2.agendaProject.Repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AutenticacaoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostConstruct
    public void seedDb() {
        if(usuarioRepository.count() == 0) {
            Usuario usuario = new Usuario();

            usuario.setEmail("admin");
            usuario.setSenha("admin123");
            usuario.setDtCadastro(new Date());
            usuario.setTipoAcesso(TipoAcessoEnum.ADMIN);

            usuarioRepository.saveAndFlush(usuario);
        }
    }

    public Usuario login(String email, String senha)
    {
        return usuarioRepository.findByEmailAndAndSenha(email, senha);
    }
}
