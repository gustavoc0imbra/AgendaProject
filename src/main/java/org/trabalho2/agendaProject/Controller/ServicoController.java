package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.trabalho2.agendaProject.Model.Servico;
import org.trabalho2.agendaProject.Service.ServicoService;

@Controller
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;

    @GetMapping("/servicos")
    public ModelAndView findAll()
    {
        ModelAndView mv = new ModelAndView("/Servico/servicos");
        mv.addObject("servicos", servicoService.findAll());

        return mv;
    }

    @GetMapping("/servico")
    public ModelAndView add(Servico servico)
    {
        ModelAndView mv = new ModelAndView("/Servico/servicoform");
        mv.addObject("servico", servico);

        return mv;
    }

    @GetMapping("/servico/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id)
    {
        return add(servicoService.encontrarServicoPorId(id).get());
    }

    @GetMapping("/servicoDel/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id)
    {
        servicoService.deletarServico(id);

        return findAll();
    }

    @PostMapping("/servico")
    public ModelAndView save(Servico servico, BindingResult result)
    {
        if(result.hasErrors())
        {
            return add(servico);
        }

        servicoService.salvarServico(servico);

        return findAll();
    }
}
