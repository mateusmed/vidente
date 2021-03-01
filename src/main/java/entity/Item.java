package entity;

import java.util.List;

public class Item {

    private Integer id;
    private String nome;
    private String regra;

    public Item() {
    }

    public Item(Integer id, String nome, String regra) {
        this.id = id;
        this.nome = nome;
        this.regra = regra;
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

    public String getRegra() {
        return regra;
    }

    public void setRegra(String regra) {
        this.regra = regra;
    }

    @Override
    public String toString() {
        return "O item que você escolheu foi: " + nome ;
    }
}
