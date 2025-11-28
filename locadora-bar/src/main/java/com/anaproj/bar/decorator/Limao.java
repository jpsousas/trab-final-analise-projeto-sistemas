package com.anaproj.bar.decorator;

import com.anaproj.bar.factory.Produto;

public class Limao extends DecoradorProduto {

    public Limao(Produto produto) {
        super(produto);
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