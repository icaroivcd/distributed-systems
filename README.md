# Remote Procedure Call (RPC) 

Este repositório contém um serviço gRPC (calculadora) gerado a partir de `src/main/proto/calculator.proto` e implementado em Java.

Pré-requisitos
- Java 17 (ou a versão configurada no `pom.xml`)
- Maven 3.6+
- Internet para baixar dependências na primeira execução

Passos rápidos
1. Compile e gere o código protobuf/gRPC:

```bash
mvn clean compile
```

2. Rode o servidor:

```bash
mvn exec:java -Dexec.mainClass="com.example.calculator.CalculatorServer"
```

3. Em outro terminal, rode o cliente:

```bash
mvn exec:java -Dexec.mainClass="com.example.calculator.CalculatorClient"
```