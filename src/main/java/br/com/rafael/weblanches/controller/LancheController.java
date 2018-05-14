package br.com.rafael.weblanches.controller;

import br.com.rafael.weblanches.entity.Lanche;
import br.com.rafael.weblanches.repository.IngredienteRepository;
import br.com.rafael.weblanches.repository.LancheRepository;
import br.com.rafael.weblanches.service.LancheService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LancheController {


    private IngredienteRepository ingredienteRepository;
    private LancheService lancheService;
    private LancheRepository lancheRepository;

    public LancheController(IngredienteRepository ingredienteRepository, LancheService lancheService, LancheRepository lancheRepository) {
        this.ingredienteRepository = ingredienteRepository;
        this.lancheService = lancheService;
        this.lancheRepository = lancheRepository;
    }

    public String index (){
        return "index";
    }

    @PostMapping("/addIngrediente")
    public String addIngrediente(@ModelAttribute Lanche lanche, @RequestParam Integer idIngrediente, Model model) {

        model.addAttribute("lanche", lancheService.adicionaIngrediente(lanche, idIngrediente));
        model.addAttribute("ingredientes", ingredienteRepository.findAll());

        return "ingredientes";
    }


    @GetMapping("/{id}")
    public String get(@PathVariable Integer id, Model model){
        model.addAttribute("lanche", lancheRepository.getById(id));
        model.addAttribute("ingredientes", ingredienteRepository.findAll());
        return "ingredientes";
    }

    @PostMapping("/save")
    public ResponseEntity<Lanche> save(@ModelAttribute Lanche lanche) {

        System.out.println("salvando...");

        return ResponseEntity.ok().build();
    }


}
