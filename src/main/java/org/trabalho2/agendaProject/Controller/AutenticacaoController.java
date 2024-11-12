package org.trabalho2.agendaProject.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.trabalho2.agendaProject.DTO.AuthenticacaoDTO;
import org.trabalho2.agendaProject.DTO.RegisterDTO;
import org.trabalho2.agendaProject.Model.Usuario;
import org.trabalho2.agendaProject.Repository.UsuarioRepository;
import org.trabalho2.agendaProject.Service.AutenticacaoService;

import java.net.http.HttpClient;
import java.time.LocalDateTime;

@Controller
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;


    @GetMapping("/")
    public ModelAndView showLogin(String mensagem) {
        ModelAndView mv = new ModelAndView("/Autenticacao/login");
        mv.addObject("mensagem", mensagem);

        return mv;
    }

    @GetMapping("/meuperfil")
    public ModelAndView editPerfil(HttpSession session)
    {
        ModelAndView mv = new ModelAndView("Usuario/usuarioperfil");
        mv.addObject("usuario", (Usuario) session.getAttribute("usuariologado"));

        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(Usuario usuario, BindingResult result, HttpSession session){

        if(result.hasErrors()) {
            showLogin("Erro: Captar informações!");
        }

        Usuario usuarioLogin = autenticacaoService.login(usuario.getEmail(), usuario.getSenha());

        if(usuarioLogin == null) {
            return showLogin("Erro: Credênciais inválidas!");
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("Dashboard/home");

        session.setAttribute("usuariologado", usuarioLogin);

        return mv;
    }

    @PostMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return showLogin(null);
    }

}
