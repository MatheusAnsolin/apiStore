package br.com.store.api.factory.produto;

import java.util.Objects;

public class Camisa extends Produto { // Produto concreto
    private String time;
    private char tamanho;

    // Construtor
    public Camisa(Long id, String nome, double preco, String time, char tamanho) {
        super(id, nome, preco);
        this.time = time;
        this.tamanho = tamanho;
    }

    @Override
    public String getDescricao() { // Implementação específica
        return "Camisa do " + this.time + ", tamanho " + this.tamanho + ". Preço: R$" + getPreco();
    }

    // Getters e Setters
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    // Métodos equals, hashCode e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Camisa camisa = (Camisa) o;
        return tamanho == camisa.tamanho && Objects.equals(time, camisa.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time, tamanho);
    }

    @Override
    public String toString() {
        return "Camisa{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", preco=" + getPreco() +
                ", time='" + time + '\'' +
                ", tamanho=" + tamanho +
                '}';
    }
}