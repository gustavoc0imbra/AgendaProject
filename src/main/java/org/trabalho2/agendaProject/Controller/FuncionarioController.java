package org.trabalho2.agendaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.trabalho2.agendaProject.Model.Funcionario;
import org.trabalho2.agendaProject.Service.FuncionarioService;

import java.util.List;
import java.util.Optional;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/Funcionario/funcionarios");
        mv.addObject("funcionarios", funcionarioService.findAll());

        return mv;
    }

    @GetMapping("/funcionario")
    public ModelAndView add(Funcionario funcionario) {
        ModelAndView mv = new ModelAndView("Funcionario/funcionarioform");
        mv.addObject("funcionario", funcionario);

        return mv;
    }

    @GetMapping("/funcionario/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        return add(funcionarioService.findById(id).get());
    }

    @PostMapping("/funcionario")
    public ModelAndView updateFuncionario(Funcionario funcionario, BindingResult result) {

        if(result.hasErrors())
        {
            for (ObjectError error: result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }

            return add(funcionario);
        }

        funcionarioService.save(funcionario);

        return findAll();
    }

    @GetMapping("/funcionarioDel/{id}")
    public ModelAndView deleteFuncionario(@PathVariable Integer id) {
        funcionarioService.deleteById(id);

        return findAll();
    }
}
