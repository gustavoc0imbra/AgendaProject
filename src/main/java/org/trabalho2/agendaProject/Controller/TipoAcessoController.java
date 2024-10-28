package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.trabalho2.agendaProject.Model.TipoAcesso;
import org.trabalho2.agendaProject.Service.TipoAcessoService;

@Controller
public class TipoAcessoController {
    @Autowired
    private TipoAcessoService tipoAcessoService;

    @GetMapping("/tipoacesso")
    public ModelAndView add(TipoAcesso tipoAcesso)
    {
        ModelAndView mv = new ModelAndView("TipoAcesso/tipoacessoform");
        mv.addObject("tipoAcesso", tipoAcesso);

        return mv;
    }

    @PostMapping("/tipoacesso")
    public RedirectView save(TipoAcesso tipoAcesso, BindingResult result)
    {
        if(result.hasErrors())
        {
            for (ObjectError error: result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }

            return new RedirectView("/");
        }

        tipoAcessoService.add(tipoAcesso);

        return new RedirectView("/usuarios");
    }
}
