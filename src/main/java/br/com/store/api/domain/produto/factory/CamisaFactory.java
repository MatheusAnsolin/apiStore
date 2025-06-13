package br.com.store.api.factory;

import br.com.store.api.factory.produto.Camisa;
import br.com.store.api.factory.produto.Produto;

public class CamisaFactory implements ProdutoFactory { // Fábrica Concreta
    @Override
    public Produto criarProduto() {
        // Lógica de criação encapsulada
        return new Camisa(1L, "Camisa Oficial", 150.00, "Time X", 'G');
    }
}