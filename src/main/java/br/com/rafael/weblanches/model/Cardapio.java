package br.com.rafael.weblanches.model;

import br.com.rafael.weblanches.entity.Lanche;

public class Cardapio {

    private Lanche lanche;

    private Double valor;

    public Cardapio() {
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
