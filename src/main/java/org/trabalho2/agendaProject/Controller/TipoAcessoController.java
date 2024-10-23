package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.trabalho2.agendaProject.Service.TipoAcessoService;

@Controller
public class TipoAcessoController {
    @Autowired
    private TipoAcessoService tipoAcessoService;
}
