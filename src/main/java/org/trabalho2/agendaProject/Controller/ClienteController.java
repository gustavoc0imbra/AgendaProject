package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.trabalho2.agendaProject.Model.Cliente;
import org.trabalho2.agendaProject.Service.ClienteService;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView findAll()
    {
        ModelAndView mv = new ModelAndView("/Cliente/clientes");
        mv.addObject("clientes", clienteService.findAll());

        return mv;
    }

    @GetMapping("/cliente")
    public ModelAndView add(Cliente cliente)
    {
        ModelAndView mv = new ModelAndView("/Cliente/clienteform");
        mv.addObject("cliente", cliente);

        return mv;
    }

    @GetMapping("/cliente/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id)
    {
        return add(clienteService.findById(id).get());
    }

    @GetMapping("/clienteDel/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id)
    {
        clienteService.delete(id);

        return findAll();
    }

    @GetMapping("/cliente/enderecos/{id}")
    public ModelAndView enderecos(@PathVariable("id") Integer id)
    {
        ModelAndView mv = new ModelAndView("Cliente/clienteendereco");

        mv.addObject("cliente", clienteService.findById(id).get());

        return mv;
    }

    @PostMapping("/cliente")
    public ModelAndView save(Cliente cliente, BindingResult result)
    {
        if(result.hasErrors())
        {
            return add(cliente);
        }

        clienteService.add(cliente);

        return findAll();
    }
}