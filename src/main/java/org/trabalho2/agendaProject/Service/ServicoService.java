package org.trabalho2.agendaProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trabalho2.agendaProject.Model.Servico;
import org.trabalho2.agendaProject.Repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> findAll()
    {
        return servicoRepository.findAll();
    }
    public Servico salvarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void deletarServico(Integer id) {
        servicoRepository.deleteById(id);
    }

    public Optional<Servico> encontrarServicoPorId(Integer id) {
        return servicoRepository.findById(id);
    }
}