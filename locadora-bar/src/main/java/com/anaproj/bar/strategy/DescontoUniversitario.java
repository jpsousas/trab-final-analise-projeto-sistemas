package com.anaproj.bar.strategy;

import com.anaproj.bar.factory.Produto;

public class DescontoUniversitario implements EstrategiaPreco {
    @Override
    public double calcular(Produto produto) {
        return produto.getPreco() * 0.8;
    }

    @Override
    public String toString() {
        return "Desconto Universitário (20% off)";
    }
}
