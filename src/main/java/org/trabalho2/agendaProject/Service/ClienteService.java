package org.trabalho2.agendaProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trabalho2.agendaProject.Model.Cliente;
import org.trabalho2.agendaProject.Repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente add(Cliente cliente) {
        return clienteRepository.saveAndFlush(cliente);
    }

    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    public void delete(Integer id){
        clienteRepository.deleteById(id);
    }
}
