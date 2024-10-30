package org.trabalho2.agendaProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.trabalho2.agendaProject.Model.Cliente;
import org.trabalho2.agendaProject.Model.Endereco;
import org.trabalho2.agendaProject.Repository.EnderecoRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    private ClienteService clienteService;
    private final WebClient webClient;

    public EnderecoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Endereco> findAll()
    {
        return enderecoRepository.findAll();
    }

    public Endereco add(String cep, Integer id)
    {
        Endereco endereco = buscarCep(cep).block();
        Cliente cliente = clienteService.findById(id).get();
        endereco.setCliente(cliente);
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> findOne(Integer id)
    {
        return enderecoRepository.findById(id);
    }

    public void delete (Integer id)
    {
        enderecoRepository.deleteById(id);
    }

    public Mono<Endereco> buscarCep(String cep) {
        return webClient
                .get()
                .uri("{cep}/json/", cep)
                .retrieve()
                .bodyToMono(Endereco.class);
    }
}
