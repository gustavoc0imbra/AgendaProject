package org.trabalho2.agendaProject.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.trabalho2.agendaProject.Service.UsuarioService;

@Controller
@RequestMapping("login")
public class AutenticacaoController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseBody login(@ResponseBody @Valid AuthenticacaoDTO authenticacaoDTO){
        
    }


}
