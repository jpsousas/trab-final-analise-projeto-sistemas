package com.anaproj.bar.decorator;

import com.anaproj.bar.factory.Cigarro;
import com.anaproj.bar.factory.Produto;

public class Limao extends DecoradorProduto {

    public Limao(Produto produto) {
        super(produto);
        if (produto instanceof Cigarro) {
            throw new IllegalArgumentException("Não é possível adicionar Limão a um Cigarro!");
        }
    }

    @Override
    public String getDescricao() {
        return produtoDecorado.getDescricao() + " + Limão";
    }

    @Override
    public double getPreco() {
        return produtoDecorado.getPreco() + 0.50;
    }
}