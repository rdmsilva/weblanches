package br.com.rafael.weblanches.service;

import br.com.rafael.weblanches.entity.Ingrediente;
import br.com.rafael.weblanches.entity.Lanche;
import br.com.rafael.weblanches.repository.IngredienteRepository;
import br.com.rafael.weblanches.util.Constante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LancheService {

    private IngredienteRepository ingredienteRepository;

    public LancheService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    /**
     * Adiciona um ingrediente ao lanche.
     *
     * @param lanche        lanche
     * @param idIngrediente id do ingrediente
     * @return              lanche com o novo ingrediente
     */
    public Lanche adicionaIngrediente(Lanche lanche, Integer idIngrediente) {

        Ingrediente ingrediente = ingredienteRepository.getById(idIngrediente);
        List<Ingrediente> ingredienteList = lanche.getIngredienteList();

        ingredienteList.add(ingrediente);
        ingredienteList.sort(Comparator.comparing(Ingrediente::getNome));
        lanche.setIngredienteList(ingredienteList);

        aplicaPromocoes(lanche);

        return lanche;

    }

    /**
     * Calcula o valor de tabela do lanche.
     *
     * @param lanche  lanche.
     * @return        valor do lanche.
     */
    public Double calculaPrecoLanche(Lanche lanche){
        return lanche.getIngredienteList().stream().mapToDouble(Ingrediente::getPreco).sum();
    }

    /**
     * Atualiza o valor do lanche conforme as Regras das Promoções:
     *
     * - Se o lanche tem alface e não tem bacon, ganha 10% de desconto.
     * - A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4.
     * - A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4.
     *
     * @param lanche lanche
     * @return       lanche com o valor atualizado.
     */
    public void aplicaPromocoes(Lanche lanche) {

        boolean desconto;
        int contCarne = 0;
        int contQueijo = 0;
        Double total;

        List<Ingrediente> ingredienteList = lanche.getIngredienteList();
        List<Ingrediente> ingredientesAux = new ArrayList<>(lanche.getIngredienteList());

        desconto = ingredienteList.stream()
                        .anyMatch(i -> i.getNome().equals(Constante.INGREDIENTE_ALFACE)
                                        && !i.getNome().equals(Constante.INGREDIENTE_BACON));

        for (Ingrediente i : ingredienteList) {

            if (i.getNome().equals(Constante.INGREDIENTE_HAMBURGUER_DE_CARNE)){
                contCarne++;
                if (contCarne % 3 == 0){
                    ingredientesAux.remove(ingredienteList.indexOf(i));
                }
            }

            if (i.getNome().equals(Constante.INGREDIENTE_QUEIJO)){
                contQueijo++;
                if (contQueijo % 3 == 0){
                    ingredientesAux.remove(ingredienteList.indexOf(i));
                }
            }
        }

        total = ingredientesAux.stream().mapToDouble(Ingrediente::getPreco).sum();

        if (desconto){
            total = total * 0.90;
        }

        lanche.setPreco(total);
    }

}
