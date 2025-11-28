package com.anaproj.bar;

import com.anaproj.bar.decorator.Gelo;
import com.anaproj.bar.decorator.Limao;
import com.anaproj.bar.factory.AguaCriadora;
import com.anaproj.bar.factory.Bebida;
import com.anaproj.bar.factory.CervejaCriadora;
import com.anaproj.bar.factory.CigarroCriadora;
import com.anaproj.bar.factory.Produto;
import com.anaproj.bar.factory.ProdutoCriadora;
import com.anaproj.bar.factory.WhiskyCriadora;
import com.anaproj.bar.observer.Gerente;
import com.anaproj.bar.singleton.Estoque;
import com.anaproj.bar.strategy.Caixa;
import com.anaproj.bar.strategy.HappyHour;
import com.anaproj.bar.strategy.PrecoNormal;
import com.anaproj.bar.ui.BarUI;

public class App {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DO BAR ===");

        Estoque estoque = Estoque.INSTANCIA;
        Gerente gerente = new Gerente();
        estoque.registrarObservador(gerente);
        System.out.println("> Gerente registrado para alertas de estoque.");

        ProdutoCriadora fabricaAgua = new AguaCriadora();
        ProdutoCriadora fabricaCerveja = new CervejaCriadora("Cerveja Pilsen", 10.00);
        ProdutoCriadora fabricaWhisky = new WhiskyCriadora("Whisky Importado", 25.00);
        ProdutoCriadora fabricaCigarro = new CigarroCriadora("Marlboro", 12.00);

        System.out.println("\n--- Carregando Estoque Inicial ---");
        estoque.adicionar(fabricaAgua.criar(), 20);
        estoque.adicionar(fabricaCerveja.criar(), 50);
        estoque.adicionar(fabricaWhisky.criar(), 10);
        estoque.adicionar(fabricaCigarro.criar(), 15);

        System.out.println("=== SISTEMA PRONTO PARA OPERAR ===\n");
        
        BarUI ui = new BarUI();
        ui.iniciar();
    }
}