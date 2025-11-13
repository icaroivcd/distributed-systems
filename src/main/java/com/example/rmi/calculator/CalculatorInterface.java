package com.example.rmi.calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface Remota para a Calculadora RMI
 * Define os métodos que podem ser chamados remotamente
 */
public interface CalculatorInterface extends Remote {
    
    /**
     * Realiza a soma de dois números
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da soma
     * @throws RemoteException em caso de erro de comunicação
     */
    double somar(double a, double b) throws RemoteException;
    
    /**
     * Realiza a subtração de dois números
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da subtração (a - b)
     * @throws RemoteException em caso de erro de comunicação
     */
    double subtrair(double a, double b) throws RemoteException;
    
    /**
     * Realiza a multiplicação de dois números
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da multiplicação
     * @throws RemoteException em caso de erro de comunicação
     */
    double multiplicar(double a, double b) throws RemoteException;
    
    /**
     * Realiza a divisão de dois números
     * @param a numerador
     * @param b denominador
     * @return resultado da divisão (a / b)
     * @throws RemoteException em caso de erro de comunicação
     * @throws ArithmeticException se b for zero
     */
    double dividir(double a, double b) throws RemoteException, ArithmeticException;
    
    /**
     * Calcula a regra de três simples
     * Se a está para b, então c está para x
     * x = (b * c) / a
     * 
     * @param a valor1
     * @param b valor2
     * @param c valor3
     * @return resultado da regra de três
     * @throws RemoteException em caso de erro de comunicação
     * @throws ArithmeticException se a for zero
     */
    double regraDeTres(double a, double b, double c) throws RemoteException, ArithmeticException;
}
