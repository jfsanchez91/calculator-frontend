package com.github.jfsanchez91.client;

import com.zonnesoft.calculator.backend.ReactorCalculatorServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel

@Factory
class ClientFactory {
    @Bean
    fun rxCalculatorBackendClient(@GrpcChannel("backend") channel: ManagedChannel): ReactorCalculatorServiceGrpc.ReactorCalculatorServiceStub =
        ReactorCalculatorServiceGrpc.newReactorStub(channel)
}
