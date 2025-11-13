package com.example.rmi.calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementação da interface remota CalculatorInterface
 * Esta classe contém a lógica das operações matemáticas
 */
public class CalculatorImplementation extends UnicastRemoteObject implements CalculatorInterface {
    
    /**
     * Construtor - necessário para exportar o objeto remoto
     * @throws RemoteException se houver falha na exportação
     */
    public CalculatorImplementation() throws RemoteException {
        super();
    }
    
    @Override
    public double somar(double a, double b) throws RemoteException {
        double resultado = a + b;
        System.out.println(String.format("Operação: %.2f + %.2f = %.2f", a, b, resultado));
        return resultado;
    }
    
    @Override
    public double subtrair(double a, double b) throws RemoteException {
        double resultado = a - b;
        System.out.println(String.format("Operação: %.2f - %.2f = %.2f", a, b, resultado));
        return resultado;
    }
    
    @Override
    public double multiplicar(double a, double b) throws RemoteException {
        double resultado = a * b;
        System.out.println(String.format("Operação: %.2f * %.2f = %.2f", a, b, resultado));
        return resultado;
    }
    
    @Override
    public double dividir(double a, double b) throws RemoteException, ArithmeticException {
        if (b == 0) {
            System.out.println("Erro: tentativa de divisão por zero");
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
        double resultado = a / b;
        System.out.println(String.format("Operação: %.2f / %.2f = %.2f", a, b, resultado));
        return resultado;
    }
    
    @Override
    public double regraDeTres(double a, double b, double c) throws RemoteException, ArithmeticException {
        if (a == 0) {
            System.out.println("Erro: tentativa de divisão por zero na regra de três");
            throw new ArithmeticException("O primeiro valor não pode ser zero na regra de três");
        }
        double resultado = (b * c) / a;
        System.out.println(String.format("Regra de três: se %.2f está para %.2f, então %.2f está para %.2f", 
                                        a, b, c, resultado));
        return resultado;
    }
}
