package org.trabalho2.agendaProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trabalho2.agendaProject.Helper.Codificador;
import org.trabalho2.agendaProject.Model.Usuario;
import org.trabalho2.agendaProject.Repository.UsuarioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario add(Usuario usuario)
    {
        if(usuario.getDtCadastro() == null) {
            usuario.setDtCadastro(new Date());
        }

        if(usuario.getSenha() == null) {
            usuario.setSenha(Codificador.criptografaPalavra("123"));
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll()
    {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id)
    {
        return usuarioRepository.findById(id);
    }

    public void delete(Integer id)
    {
        usuarioRepository.deleteById(id);
    }

    public int countUsuarioByEmailAndSenha(String email, String senha)
    {
        return usuarioRepository.countUsuarioByEmailAndSenha(email, Codificador.criptografaPalavra(senha));
    }

}
