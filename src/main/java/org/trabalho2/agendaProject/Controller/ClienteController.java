package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.trabalho2.agendaProject.Service.ClienteService;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/Cliente/clientes");
        mv.addObject("clientes", clienteService.findAll());

        return mv;
    }
}
