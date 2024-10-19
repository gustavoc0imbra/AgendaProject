package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.trabalho2.agendaProject.Model.Usuario;
import org.trabalho2.agendaProject.Service.UsuarioService;

@Controller
public class AutenticacaoController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ModelAndView mostraLogin(String mensagem)
    {
        ModelAndView mv = new ModelAndView("/Autenticacao/login");
        mv.addObject("mensagem", mensagem);

        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(Usuario usuario)
    {
        if(usuarioService.findById(usuario.getId()).isEmpty()) {
            return mostraLogin("Usuário não encontrado");
        }

        ModelAndView mv = new ModelAndView("/Dashboard/dashboard");
        mv.addObject("usuario", usuario);

        return mv;
    }
}
