package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.trabalho2.agendaProject.Model.Cliente;
import org.trabalho2.agendaProject.Model.Endereco;
import org.trabalho2.agendaProject.Service.ClienteService;
import org.trabalho2.agendaProject.Service.EnderecoService;
import reactor.core.publisher.Mono;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

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

    @PostMapping("/cliente")
    public ModelAndView save(Cliente cliente, BindingResult result)
    {
        if(result.hasErrors())
        {
            return add(cliente);
        }

        cliente.setEndereco(enderecoService.add(cliente.getEndereco()));
        clienteService.add(cliente);

        return findAll();
    }
}