package br.com.store.api.factory.produto;

import java.util.Objects;

public class Caneca extends Produto { // Produto concreto
    private String material;

    // Construtor
    public Caneca(Long id, String nome, double preco, String material) {
        super(id, nome, preco);
        this.material = material;
    }

    @Override
    public String getDescricao() { // Implementação específica
        return "Caneca de " + this.material + ". Preço: R$" + getPreco();
    }

    // Getters e Setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // Métodos equals, hashCode e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Caneca caneca = (Caneca) o;
        return Objects.equals(material, caneca.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material);
    }

    @Override
    public String toString() {
        return "Caneca{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", preco=" + getPreco() +
                ", material='" + material + '\'' +
                '}';
    }
}