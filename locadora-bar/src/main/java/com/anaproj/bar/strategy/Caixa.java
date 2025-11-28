package com.anaproj.bar.strategy;

import com.anaproj.bar.factory.Produto;

public class Caixa {
    private EstrategiaPreco estrategia;
    private double saldoDoDia;

    public Caixa(EstrategiaPreco estrategiaInicial) {
        this.estrategia = estrategiaInicial;
        this.saldoDoDia = 0.0;
    }

    public void setEstrategia(EstrategiaPreco estrategia) {
        this.estrategia = estrategia;
        System.out.println("--- CAIXA: Regra de preço alterada ---");
    }

    public String getNomeEstrategia() {
        return this.estrategia.toString();
    }

    public void cobrar(Produto produto) {
        double valorFinal = estrategia.calcular(produto);

        this.saldoDoDia += valorFinal;

        System.out.println(String.format("CAIXA: Cobrando '%s' | Original: R$ %.2f | Final: R$ %.2f", 
            produto.getDescricao(), produto.getPreco(), valorFinal));
    }

    public void imprimirFechamentoCaixa() {
        System.out.println("\n=== FECHAMENTO DE CAIXA ===");
        System.out.println(String.format("Total Vendido no Dia: R$ %.2f", this.saldoDoDia));
        System.out.println("===========================");
    }
}