package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trabalho2.agendaProject.Service.RelatorioService;
import org.trabalho2.agendaProject.Model.Servico;
import org.trabalho2.agendaProject.Model.Agenda;
import org.trabalho2.agendaProject.Model.Funcionario;
import org.trabalho2.agendaProject.Model.Cliente;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/servicos")
    public List<Servico> gerarRelatorioServicos() {
        return relatorioService.gerarRelatorioServicos();
    }

    @GetMapping("/agendas")
    public List<Agenda> gerarRelatorioAgendas() {
        return relatorioService.gerarRelatorioAgendas();
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> gerarRelatorioFuncionarios() {
        return relatorioService.gerarRelatorioFuncionarios();
    }

    @GetMapping("/clientes")
    public List<Cliente> gerarRelatorioClientes() {
        return relatorioService.gerarRelatorioClientes();
    }
}