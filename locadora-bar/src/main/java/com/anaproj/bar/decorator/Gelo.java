package com.anaproj.bar.decorator;

import com.anaproj.bar.factory.Cigarro;
import com.anaproj.bar.factory.Produto;

public class Gelo extends DecoradorProduto {

    public Gelo(Produto produto) {
        super(produto);
        if (produto instanceof Cigarro) {
            throw new IllegalArgumentException("Não é possível adicionar Gelo a um Cigarro!");
        }
    }

    @Override
    public String getDescricao() {
        return produtoDecorado.getDescricao() + " + Gelo";
    }

    @Override
    public double getPreco() {
        return produtoDecorado.getPreco() + 1.00;
    }
}