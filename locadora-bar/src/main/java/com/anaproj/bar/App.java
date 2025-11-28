package com.anaproj.bar;

import com.anaproj.bar.decorator.Gelo;
import com.anaproj.bar.decorator.Limao;
import com.anaproj.bar.factory.Agua;
import com.anaproj.bar.factory.Cerveja;
import com.anaproj.bar.factory.Cigarro;
import com.anaproj.bar.factory.Produto;
import com.anaproj.bar.factory.Whisky;
import com.anaproj.bar.observer.Gerente;
import com.anaproj.bar.singleton.Estoque;
import com.anaproj.bar.strategy.Caixa;
import com.anaproj.bar.strategy.DescontoUniversitario;
import com.anaproj.bar.strategy.HappyHour;
import com.anaproj.bar.strategy.PrecoNormal;

public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA LOCADORA BAR - PADRÕES DE PROJETO ===");
        
        System.out.println("\n--- 1. Instanciação (Factory/Simples) ---");
        Produto heineken = new Cerveja("cerveja", "Cerveja Heineken", 7.50);
        Produto jackDaniels = new Whisky("whisky", "Whisky Jack Daniel's", 110.00);
        Produto marlboro = new Cigarro("cigarro", "Cigarro Marlboro", 12.00);
        
        System.out.println("Criado: " + heineken.getDescricao() + " | R$ " + heineken.getPreco());
        System.out.println("Criado: " + jackDaniels.getDescricao() + " | R$ " + jackDaniels.getPreco());

        System.out.println("\n--- 2. Estoque (Singleton) & Notificação (Observer) ---");
        Estoque estoque = Estoque.INSTANCIA;
        Gerente gerente = new Gerente();
        estoque.registrarObservador(gerente);

        estoque.adicionar(heineken, 20);
        estoque.adicionar(jackDaniels, 5);

        System.out.println(">> Vendendo 1 Heineken...");
        estoque.darBaixa(heineken, 1);

        System.out.println(">> Vendendo 1 Jack Daniels (deve acionar Observer se cair abaixo de 5)...");
        estoque.darBaixa(jackDaniels, 1); 

        System.out.println("\n--- 3. Personalização de Bebidas (Decorator) ---");
        
        Produto meuWhisky = new Whisky("whisky", "Old Parr", 150.00);
        System.out.println("Puro: " + meuWhisky.getDescricao() + " = R$ " + meuWhisky.getPreco());
        
        Produto whiskyComGelo = new Gelo(meuWhisky);
        System.out.println("Decorado 1: " + whiskyComGelo.getDescricao() + " = R$ " + whiskyComGelo.getPreco());
        
        Produto whiskyCompleto = new Limao(whiskyComGelo);
        System.out.println("Decorado 2: " + whiskyCompleto.getDescricao() + " = R$ " + whiskyCompleto.getPreco());

        System.out.println("\n--- 4. Pagamento (Strategy) ---");
        Caixa caixa = new Caixa(new PrecoNormal());
        
        System.out.println(">> Cobrando Whisky Completo (Preço Normal):");
        caixa.cobrar(whiskyCompleto);

        System.out.println("\n>> Ativando Happy Hour (Strategy):");
        caixa.setEstrategia(new HappyHour());
        
        System.out.println(">> Cobrando o mesmo Whisky no Happy Hour (50% off):");
        caixa.cobrar(whiskyCompleto); 
        
        System.out.println(">> Cobrando Cigarro no Happy Hour (Sem desconto):");
        caixa.cobrar(marlboro);
    }
}