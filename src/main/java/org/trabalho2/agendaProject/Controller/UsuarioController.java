package org.trabalho2.agendaProject.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.trabalho2.agendaProject.Enum.TipoAcessoEnum;
import org.trabalho2.agendaProject.Model.Usuario;
import org.trabalho2.agendaProject.Service.UsuarioService;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ModelAndView findAll()
    {
        ModelAndView mv = new ModelAndView("Usuario/usuarios");
        mv.addObject("usuarios", usuarioService.findAll());

        return mv;
    }

    @GetMapping("/usuario")
    public ModelAndView add(Usuario usuario)
    {
        ModelAndView mv = new ModelAndView("/Usuario/usuarioform");
        mv.addObject("tiposAcesso", TipoAcessoEnum.values());
        mv.addObject("usuario", usuario);

        return mv;
    }

    @GetMapping("/usuario/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id)
    {
        return add(usuarioService.findById(id).get());
    }

    @GetMapping("/usuarioDel/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id)
    {
        usuarioService.delete(id);

        return findAll();
    }

    @PostMapping("/usuario")
    public ModelAndView save(Usuario usuario, BindingResult result, HttpSession session)
    {
        if(result.hasErrors())
        {
            return add(usuario);
        }
        Usuario usuarioform = (Usuario) session.getAttribute("usuariologado");

        if(usuarioform.getEmail().equals(usuario.getEmail())) {
            session.removeAttribute("usuariologado");
            session.setAttribute("usuariologado", usuario);
        }

        usuarioService.add(usuario);

        return findAll();
    }
}
