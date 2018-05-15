package br.com.rafael.weblanches.util;

import br.com.rafael.weblanches.entity.Ingrediente;
import br.com.rafael.weblanches.entity.Lanche;
import br.com.rafael.weblanches.repository.IngredienteRepository;
import br.com.rafael.weblanches.repository.LancheRepository;
import br.com.rafael.weblanches.service.LancheService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Configuracao {

    private IngredienteRepository ingredienteRepository;
    private LancheRepository lancheRepository;
    private LancheService lancheService;

    public Configuracao(IngredienteRepository ingredienteRepository, LancheRepository lancheRepository, LancheService lancheService) {
        this.ingredienteRepository = ingredienteRepository;
        this.lancheRepository = lancheRepository;
        this.lancheService = lancheService;
    }

    @Bean
    public String inicial(){

        Lanche lanche;
        List<Ingrediente> ingredientes;

        lanche = new Lanche();
        ingredientes = new ArrayList<>();
        lanche.setNome("X-Bacon");
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_BACON));
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_HAMBURGUER_DE_CARNE));
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_QUEIJO));
        lanche.setIngredienteList(ingredientes);
        lanche.setPreco(lancheService.calculaPrecoLanche(lanche));
        lancheRepository.save(lanche);

        lanche = new Lanche();
        ingredientes = new ArrayList<>();
        lanche.setNome("X-Burguer");
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_HAMBURGUER_DE_CARNE));
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_QUEIJO));
        lanche.setIngredienteList(ingredientes);
        lanche.setPreco(lancheService.calculaPrecoLanche(lanche));
        lancheRepository.save(lanche);

        lanche = new Lanche();
        ingredientes = new ArrayList<>();
        lanche.setNome("X-Egg");
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_OVO));
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_HAMBURGUER_DE_CARNE));
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_QUEIJO));
        lanche.setIngredienteList(ingredientes);
        lanche.setPreco(lancheService.calculaPrecoLanche(lanche));
        lancheRepository.save(lanche);

        lanche = new Lanche();
        ingredientes = new ArrayList<>();
        lanche.setNome("X-Egg Bacon");
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_OVO));
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_BACON));
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_HAMBURGUER_DE_CARNE));
        ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_QUEIJO));
        lanche.setIngredienteList(ingredientes);
        lanche.setPreco(lancheService.calculaPrecoLanche(lanche));
        lancheRepository.save(lanche);

        return "Ok";

    }

}
