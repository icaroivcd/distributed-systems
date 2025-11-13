package com.example.rmi.calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Servidor RMI da Calculadora
 * Responsável por criar o registro RMI e vincular o objeto remoto
 */
public class CalculatorRMIServer {
    
    public static void main(String[] args) {
        try {
            // Cria a implementação do objeto remoto
            CalculatorImplementation calculator = new CalculatorImplementation();
            
            // Cria o registro RMI na porta 1099 (porta padrão)
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Vincula o objeto remoto ao registro com o nome "CalculatorService"
            registry.rebind("CalculatorService", calculator);
            
            System.out.println("===================================================");
            System.out.println("   Servidor RMI da Calculadora iniciado!");
            System.out.println("===================================================");
            System.out.println("Porta: 1099");
            System.out.println("Nome do serviço: CalculatorService");
            System.out.println("Aguardando chamadas remotas...");
            System.out.println("===================================================");
            System.out.println("\nPressione Ctrl+C para encerrar o servidor.\n");
            
            // Mantém o servidor rodando indefinidamente
            // Previne que a JVM encerre e o servidor pare de funcionar
            Thread.currentThread().join();
            
        } catch (InterruptedException e) {
            System.out.println("\nServidor RMI encerrado.");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor RMI:");
            e.printStackTrace();
        }
    }
}
