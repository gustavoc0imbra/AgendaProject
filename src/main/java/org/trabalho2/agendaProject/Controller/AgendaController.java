package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.trabalho2.agendaProject.Model.Agenda;
import org.trabalho2.agendaProject.Service.AgendaService;
import org.trabalho2.agendaProject.Service.ClienteService;
import org.trabalho2.agendaProject.Service.ServicoService;

@Controller
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/agendas")
    public ModelAndView findAll()
    {
        ModelAndView mv = new ModelAndView("/Agenda/agendas");
        mv.addObject("agendas", agendaService.findAll());

        return mv;
    }

    @GetMapping("/agenda")
    public ModelAndView add(Agenda agenda)
    {
        ModelAndView mv = new ModelAndView("Agenda/agendaform");
        mv.addObject("agenda", agenda);
        mv.addObject("clientes", clienteService.findAll());
        mv.addObject("servicos", servicoService.findAll());

        return mv;
    }

    @GetMapping("/agenda/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id)
    {
        return add(agendaService.findById(id).get());
    }

    @GetMapping("/agendaDel/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id)
    {
        agendaService.delete(id);

        return findAll();
    }

    @PostMapping("/agenda")
    public ModelAndView save(Agenda agenda, BindingResult result)
    {
        if(result.hasErrors()) {

            for (ObjectError error:
                 result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }

            return add(agenda);
        }

        agendaService.add(agenda);

        return findAll();
    }

}
