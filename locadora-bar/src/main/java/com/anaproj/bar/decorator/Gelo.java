package com.anaproj.bar.decorator;

import com.anaproj.bar.factory.Produto;

public class Gelo extends DecoradorProduto {

    public Gelo(Produto produto) {
        super(produto);
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