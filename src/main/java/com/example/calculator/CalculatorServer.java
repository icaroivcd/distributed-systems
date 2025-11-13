package com.example.calculator;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CalculatorServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new CalculatorServiceImpl())
                .build()
                .start();

        System.out.println("Servidor gRPC iniciado na porta 50051...");
        server.awaitTermination();
    }

    static class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

        @Override
        public void calculate(CalcRequest request, StreamObserver<CalcResponse> responseObserver) {
            double a = request.getA();
            double b = request.getB();
            double c = request.getC();
            String op = request.getOperation();

            double result = 0;
            String message = "";

            switch (op) {
                case "add": result = a + b; message = "Soma realizada"; break;
                case "sub": result = a - b; message = "Subtração realizada"; break;
                case "mul": result = a * b; message = "Multiplicação realizada"; break;
                case "div":
                    if (b == 0) { result = 0; message = "Erro: divisão por zero"; }
                    else { result = a / b; message = "Divisão realizada"; }
                    break;

                case "rule3":
                    if (a == 0) {
                        result = 0;
                        message = "Erro: divisão por zero (valor1 não pode ser 0)";
                    } else {
                        result = (b * c) / a;
                        message = "Regra de 3 aplicada";
                    }
                    break;

                default:
                    message = "Operação desconhecida";
            }

            CalcResponse response = CalcResponse.newBuilder()
                    .setResult(result)
                    .setMessage(message)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }


    }
}

