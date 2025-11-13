package com.example.rmi.calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Cliente RMI da Calculadora
 * Conecta-se ao servidor e realiza chamadas remotas aos métodos
 */
public class CalculatorRMIClient {
    
    public static void main(String[] args) {
        try {
            // Obtém o registro RMI do servidor (localhost:1099)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Busca o objeto remoto pelo nome
            CalculatorInterface calculator = (CalculatorInterface) registry.lookup("CalculatorService");
            
            System.out.println("===================================================");
            System.out.println("   Cliente RMI da Calculadora");
            System.out.println("===================================================");
            System.out.println("Conectado ao servidor RMI!\n");
            
            // Menu interativo
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;
            
            while (continuar) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Somar");
                System.out.println("2. Subtrair");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("5. Regra de Três");
                System.out.println("6. Executar Testes Automáticos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                
                int opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        realizarSoma(calculator, scanner);
                        break;
                    case 2:
                        realizarSubtracao(calculator, scanner);
                        break;
                    case 3:
                        realizarMultiplicacao(calculator, scanner);
                        break;
                    case 4:
                        realizarDivisao(calculator, scanner);
                        break;
                    case 5:
                        realizarRegraDeTres(calculator, scanner);
                        break;
                    case 6:
                        executarTestesAutomaticos(calculator);
                        break;
                    case 0:
                        continuar = false;
                        System.out.println("Encerrando cliente...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
            
            scanner.close();
            
        } catch (Exception e) {
            System.err.println("Erro no cliente RMI:");
            e.printStackTrace();
        }
    }
    
    private static void realizarSoma(CalculatorInterface calculator, Scanner scanner) {
        try {
            System.out.print("Digite o primeiro número: ");
            double a = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double b = scanner.nextDouble();
            
            double resultado = calculator.somar(a, b);
            System.out.println(String.format("Resultado: %.2f + %.2f = %.2f", a, b, resultado));
        } catch (Exception e) {
            System.err.println("Erro ao executar operação: " + e.getMessage());
        }
    }
    
    private static void realizarSubtracao(CalculatorInterface calculator, Scanner scanner) {
        try {
            System.out.print("Digite o primeiro número: ");
            double a = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double b = scanner.nextDouble();
            
            double resultado = calculator.subtrair(a, b);
            System.out.println(String.format("Resultado: %.2f - %.2f = %.2f", a, b, resultado));
        } catch (Exception e) {
            System.err.println("Erro ao executar operação: " + e.getMessage());
        }
    }
    
    private static void realizarMultiplicacao(CalculatorInterface calculator, Scanner scanner) {
        try {
            System.out.print("Digite o primeiro número: ");
            double a = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double b = scanner.nextDouble();
            
            double resultado = calculator.multiplicar(a, b);
            System.out.println(String.format("Resultado: %.2f * %.2f = %.2f", a, b, resultado));
        } catch (Exception e) {
            System.err.println("Erro ao executar operação: " + e.getMessage());
        }
    }
    
    private static void realizarDivisao(CalculatorInterface calculator, Scanner scanner) {
        try {
            System.out.print("Digite o numerador: ");
            double a = scanner.nextDouble();
            System.out.print("Digite o denominador: ");
            double b = scanner.nextDouble();
            
            double resultado = calculator.dividir(a, b);
            System.out.println(String.format("Resultado: %.2f / %.2f = %.2f", a, b, resultado));
        } catch (ArithmeticException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao executar operação: " + e.getMessage());
        }
    }
    
    private static void realizarRegraDeTres(CalculatorInterface calculator, Scanner scanner) {
        try {
            System.out.println("Regra de três: se A está para B, então C está para X");
            System.out.print("Digite o valor A: ");
            double a = scanner.nextDouble();
            System.out.print("Digite o valor B: ");
            double b = scanner.nextDouble();
            System.out.print("Digite o valor C: ");
            double c = scanner.nextDouble();
            
            double resultado = calculator.regraDeTres(a, b, c);
            System.out.println(String.format("Se %.2f está para %.2f, então %.2f está para %.2f", 
                                            a, b, c, resultado));
        } catch (ArithmeticException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao executar operação: " + e.getMessage());
        }
    }
    
    private static void executarTestesAutomaticos(CalculatorInterface calculator) {
        System.out.println("\n===== EXECUTANDO TESTES AUTOMÁTICOS =====\n");
        
        try {
            // Teste de soma
            System.out.println("Teste 1: Soma");
            double resultadoSoma = calculator.somar(10, 5);
            System.out.println("10 + 5 = " + resultadoSoma);
            System.out.println("Esperado: 15.0 | Obtido: " + resultadoSoma + " | " + 
                             (resultadoSoma == 15.0 ? "✓ PASSOU" : "✗ FALHOU") + "\n");
            
            // Teste de subtração
            System.out.println("Teste 2: Subtração");
            double resultadoSub = calculator.subtrair(20, 8);
            System.out.println("20 - 8 = " + resultadoSub);
            System.out.println("Esperado: 12.0 | Obtido: " + resultadoSub + " | " + 
                             (resultadoSub == 12.0 ? "✓ PASSOU" : "✗ FALHOU") + "\n");
            
            // Teste de multiplicação
            System.out.println("Teste 3: Multiplicação");
            double resultadoMul = calculator.multiplicar(6, 7);
            System.out.println("6 * 7 = " + resultadoMul);
            System.out.println("Esperado: 42.0 | Obtido: " + resultadoMul + " | " + 
                             (resultadoMul == 42.0 ? "✓ PASSOU" : "✗ FALHOU") + "\n");
            
            // Teste de divisão
            System.out.println("Teste 4: Divisão");
            double resultadoDiv = calculator.dividir(20, 4);
            System.out.println("20 / 4 = " + resultadoDiv);
            System.out.println("Esperado: 5.0 | Obtido: " + resultadoDiv + " | " + 
                             (resultadoDiv == 5.0 ? "✓ PASSOU" : "✗ FALHOU") + "\n");
            
            // Teste de divisão por zero
            System.out.println("Teste 5: Divisão por zero (deve gerar erro)");
            try {
                calculator.dividir(10, 0);
                System.out.println("✗ FALHOU - Deveria ter lançado ArithmeticException\n");
            } catch (ArithmeticException e) {
                System.out.println("✓ PASSOU - Erro tratado corretamente: " + e.getMessage() + "\n");
            }
            
            // Teste de regra de três
            System.out.println("Teste 6: Regra de Três");
            double resultadoRegra = calculator.regraDeTres(20, 50, 10);
            System.out.println("Se 20 está para 50, então 10 está para " + resultadoRegra);
            System.out.println("Esperado: 25.0 | Obtido: " + resultadoRegra + " | " + 
                             (resultadoRegra == 25.0 ? "✓ PASSOU" : "✗ FALHOU") + "\n");
            
            System.out.println("===== TESTES CONCLUÍDOS =====\n");
            
        } catch (Exception e) {
            System.err.println("Erro ao executar testes: " + e.getMessage());
        }
    }
}
