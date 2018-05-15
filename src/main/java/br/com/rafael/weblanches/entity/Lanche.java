package br.com.rafael.weblanches.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lanche {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private Double preco;

    @ManyToMany
    @JoinTable(name="lanche_ingrediente",
               joinColumns={@JoinColumn(name="lanche_id", referencedColumnName="id")},
               inverseJoinColumns={@JoinColumn(name="ingrediente_id", referencedColumnName="id")})
    private List<Ingrediente> ingredienteList;


    public Lanche() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Ingrediente> getIngredienteList() {
        return ingredienteList;
    }

    public void setIngredienteList(List<Ingrediente> ingredienteList) {
        this.ingredienteList = ingredienteList;
    }
}
