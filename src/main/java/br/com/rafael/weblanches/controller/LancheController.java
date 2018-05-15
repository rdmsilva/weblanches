package br.com.rafael.weblanches.controller;

import br.com.rafael.weblanches.entity.Lanche;
import br.com.rafael.weblanches.entity.Pedido;
import br.com.rafael.weblanches.repository.IngredienteRepository;
import br.com.rafael.weblanches.repository.LancheRepository;
import br.com.rafael.weblanches.repository.PedidoRepository;
import br.com.rafael.weblanches.service.LancheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LancheController {


    private IngredienteRepository ingredienteRepository;
    private LancheService lancheService;
    private LancheRepository lancheRepository;
    private PedidoRepository pedidoRepository;

    public LancheController(IngredienteRepository ingredienteRepository, LancheService lancheService, LancheRepository lancheRepository, PedidoRepository pedidoRepository) {
        this.ingredienteRepository = ingredienteRepository;
        this.lancheService = lancheService;
        this.lancheRepository = lancheRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public String index (){
        return "index";
    }

    @PostMapping("/addIngrediente")
    public String addIngrediente(@ModelAttribute Lanche lanche, @RequestParam Integer idIngrediente, Model model) {

        model.addAttribute("lanche", lancheService.adicionaIngrediente(lanche, idIngrediente));
        model.addAttribute("ingredientes", ingredienteRepository.findAll());

        return "confirmacao";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Integer id, Model model){
        model.addAttribute("lanche", lancheRepository.getById(id));
        model.addAttribute("ingredientes", ingredienteRepository.findAll());
        return "confirmacao";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Lanche lanche, Model model) {

        Pedido pedido = new Pedido();
        pedido.setLanche(lanche);
        pedidoRepository.save(pedido);

        model.addAttribute("pedido", pedido);

        return "finalizado";
    }

    @GetMapping("/pedidos")
    public String pedidos(Model model){
        model.addAttribute("pedidoList", pedidoRepository.findAll());
        return "pedidos";
    }


}
