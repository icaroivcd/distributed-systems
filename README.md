# Calculadora Remota - RPC e RMI

Implementação de uma calculadora remota usando **gRPC** e **Java RMI**.

## Pré-requisitos

- Java 17
- Maven 3.6+

## Operações Disponíveis

Soma, subtração, multiplicação, divisão e regra de três.

---

## 1. gRPC (Remote Procedure Call)

**O que é:** Framework do Google para chamadas remotas usando HTTP/2 e Protocol Buffers.

### Como Executar

```bash
# Compilar
mvn clean compile

# Terminal 1 - Servidor
mvn exec:java -Dexec.mainClass="com.example.calculator.CalculatorServer"

# Terminal 2 - Cliente
mvn exec:java -Dexec.mainClass="com.example.calculator.CalculatorClient"
```

**Como funciona:**
- Cliente envia uma requisição com valores e operação
- Servidor processa e retorna o resultado
- Comunicação via Protocol Buffers (porta 50051)

---

## 2. Java RMI (Remote Method Invocation)

**O que é:** Tecnologia Java que permite invocar métodos em objetos remotos como se fossem locais.

### Como Executar

```bash
# Compilar
mvn clean compile

# Terminal 1 - Servidor (deixe rodando)
mvn exec:java -Dexec.mainClass="com.example.rmi.calculator.CalculatorRMIServer"

# Terminal 2 - Cliente
mvn exec:java -Dexec.mainClass="com.example.rmi.calculator.CalculatorRMIClient"
```

**Menu do Cliente:**
1. Somar
2. Subtrair
3. Multiplicar
4. Dividir
5. Regra de Três
6. Executar Testes Automáticos
0. Sair

**Como funciona:**
- Servidor registra objeto remoto no RMI Registry (porta 1099)
- Cliente busca objeto pelo nome "CalculatorService"
- Cliente chama métodos remotos como se fossem locais
- RMI cuida da comunicação de rede automaticamente

---

## Comparação

| Característica | gRPC | Java RMI |
|----------------|------|----------|
| **Linguagens** | Multi-linguagem | Apenas Java |
| **Protocolo** | HTTP/2 + Protobuf | JRMP |
| **Porta** | 50051 | 1099 |
| **Uso** | Microserviços modernos | Sistemas Java legacy |
