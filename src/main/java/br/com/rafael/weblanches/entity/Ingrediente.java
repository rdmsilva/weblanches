package br.com.rafael.weblanches.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private Double preco;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="lanche_ingrediente",
               joinColumns={@JoinColumn(name="ingrediente_id", referencedColumnName="id")},
               inverseJoinColumns={@JoinColumn(name="lanche_id", referencedColumnName="id")})
    private List<Lanche> lancheList;

    public Ingrediente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Lanche> getLancheList() {
        return lancheList;
    }

    public void setLancheList(List<Lanche> lancheList) {
        this.lancheList = lancheList;
    }
}
