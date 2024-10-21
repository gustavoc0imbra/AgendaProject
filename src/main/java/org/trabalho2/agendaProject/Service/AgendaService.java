package org.trabalho2.agendaProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trabalho2.agendaProject.Model.Agenda;
import org.trabalho2.agendaProject.Repository.AgendaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> findAll()
    {
        return agendaRepository.findAll();
    }

    public Agenda add(Agenda agenda)
    {
        return agendaRepository.saveAndFlush(agenda);
    }

    public Optional<Agenda> findById(Integer id)
    {
        return agendaRepository.findById(id);
    }

    public void delete(Integer id)
    {
        agendaRepository.deleteById(id);
    }
}
