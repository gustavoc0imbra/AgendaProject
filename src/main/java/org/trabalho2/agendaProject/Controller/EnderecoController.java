package org.trabalho2.agendaProject.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.trabalho2.agendaProject.Model.Endereco;
import org.trabalho2.agendaProject.Service.EnderecoService;
import reactor.core.publisher.Mono;

@RestController
public class EnderecoController {

    private final EnderecoService cepService;

    @Autowired
    public EnderecoController(EnderecoService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/cep/{cep}")
    public Mono<Endereco> buscarCep(@PathVariable String cep) {
        return cepService.buscarCep(cep);
    }
}