package br.com.store.api.factory;

import br.com.store.api.factory.produto.Caneca;
import br.com.store.api.factory.produto.Produto;

public class CanecaFactory implements ProdutoFactory { // Fábrica Concreta
    @Override
    public Produto criarProduto() {
        // Lógica de criação encapsulada
        return new Caneca(2L, "Caneca Branca", 45.00, "Porcelana");
    }
}