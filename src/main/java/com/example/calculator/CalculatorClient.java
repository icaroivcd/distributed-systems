package com.example.calculator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        CalculatorServiceGrpc.CalculatorServiceBlockingStub stub =
                CalculatorServiceGrpc.newBlockingStub(channel);

        CalcRequest req = CalcRequest.newBuilder()
                .setA(20)
                .setB(50)
                .setC(10)
                .setOperation("rule3")
                .build();


        CalcResponse res = stub.calculate(req);

        System.out.println("Resultado: " + res.getResult());
        System.out.println("Mensagem: " + res.getMessage());

        channel.shutdown();
    }
}
