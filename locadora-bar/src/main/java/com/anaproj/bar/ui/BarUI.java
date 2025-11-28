package com.anaproj.bar.ui;

import java.util.Scanner;
import com.anaproj.bar.strategy.Caixa;
import com.anaproj.bar.strategy.DescontoUniversitario;
import com.anaproj.bar.strategy.HappyHour;
import com.anaproj.bar.strategy.PrecoNormal;

public class BarUI {
    private final Caixa caixa;
    private final Scanner scanner;

    public BarUI() {
        this.caixa = new Caixa(new PrecoNormal());
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== MENU BAR ===");
            System.out.println("1. Realizar Venda");
            System.out.println("2. Configurar Cobrança (Strategy)");
            System.out.println("3. Ver Estoque");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    System.out.println(">> Funcionalidade de Venda será implementada a seguir.");
                    break;
                case 2:
                    alterarEstrategia();
                    break;
                case 3:
                    System.out.println(">> Consulta de estoque indisponível neste menu (apenas logs).");
                    break;
                case 0:
                    rodando = false;
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void alterarEstrategia() {
        System.out.println("\n--- CONFIGURAR COBRANÇA (Strategy) ---");
        System.out.println("1. Preço Normal");
        System.out.println("2. Happy Hour (50% desc, exceto tabaco)");
        System.out.println("3. Universitário (20% desc total)");
        System.out.print("Escolha a regra: ");

        int regra = lerInteiro();
        switch (regra) {
            case 1:
                caixa.setEstrategia(new PrecoNormal());
                break;
            case 2:
                caixa.setEstrategia(new HappyHour());
                break;
            case 3:
                caixa.setEstrategia(new DescontoUniversitario());
                break;
            default:
                System.out.println("Regra inválida. Mantendo a atual.");
        }
    }
    
    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}