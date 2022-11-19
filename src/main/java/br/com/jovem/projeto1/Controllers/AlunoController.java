package br.com.jovem.projeto1.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.jovem.projeto1.model.Aluno;

@Controller
public class AlunoController {

    List<Aluno> alunos = new ArrayList<>();

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String cadastro(Aluno aluno) {
        alunos.add(new Aluno(aluno.getNome(), aluno.getData(), aluno.getEndereco(), aluno.getTelefone(),
                aluno.getEmail()));
        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("alunos", alunos);
        return mv;
    }
}
