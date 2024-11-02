package org.trabalho2.agendaProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trabalho2.agendaProject.Model.*;
import org.trabalho2.agendaProject.Repository.*;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Servico> gerarRelatorioServicos() {
        return servicoRepository.findAll();
    }

    public List<Agenda> gerarRelatorioAgendas() {
        return agendaRepository.findAll();
    }

    public List<Funcionario> gerarRelatorioFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public List<Cliente> gerarRelatorioClientes() {
        return clienteRepository.findAll();
    }
}