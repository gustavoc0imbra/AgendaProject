package org.trabalho2.agendaProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trabalho2.agendaProject.Model.TipoAcesso;
import org.trabalho2.agendaProject.Repository.TipoAcessoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAcessoService {
    @Autowired
    private TipoAcessoRepository tipoAcessoRepository;

    public TipoAcesso add(TipoAcesso usuario)
    {
        return tipoAcessoRepository.save(usuario);
    }

    public List<TipoAcesso> findAll()
    {
        return tipoAcessoRepository.findAll();
    }

    public Optional<TipoAcesso> findById(Integer id)
    {
        return tipoAcessoRepository.findById(id);
    }

    public void delete(Integer id)
    {
        tipoAcessoRepository.deleteById(id);
    }
}
