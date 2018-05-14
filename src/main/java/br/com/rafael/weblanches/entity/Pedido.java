package br.com.rafael.weblanches.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private Integer id;

//    @JoinColumn(name = "lanche_id")
//    private Lanche lanche;

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Lanche getLanche() {
//        return lanche;
//    }
//
//    public void setLanche(Lanche lanche) {
//        this.lanche = lanche;
//    }
}
