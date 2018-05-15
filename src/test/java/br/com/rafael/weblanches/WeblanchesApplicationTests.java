package br.com.rafael.weblanches;

import br.com.rafael.weblanches.entity.Ingrediente;
import br.com.rafael.weblanches.entity.Lanche;
import br.com.rafael.weblanches.repository.IngredienteRepository;
import br.com.rafael.weblanches.service.LancheService;
import br.com.rafael.weblanches.util.Constante;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeblanchesApplicationTests {

	@Autowired
	IngredienteRepository ingredienteRepository;

	@Autowired
	LancheService lancheService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testPrecoLancheXBacon(){
		Lanche lanche = new Lanche();
		List<Ingrediente> ingredientes = new ArrayList<>();
		lanche.setNome("X-Bacon");
		ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_BACON));
		ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_HAMBURGUER_DE_CARNE));
		ingredientes.add(ingredienteRepository.findByNome(Constante.INGREDIENTE_QUEIJO));
		lanche.setIngredienteList(ingredientes);

		Double valorEsperado = ingredientes.stream().mapToDouble(Ingrediente::getPreco).sum();
		Double valorCalculado = lancheService.calculaPrecoLanche(lanche);

		Assert.assertEquals("Preço Lanche X-Bacon", valorEsperado, valorCalculado);

	}

}
