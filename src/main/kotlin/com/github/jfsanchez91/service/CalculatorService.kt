package com.github.jfsanchez91.service

import com.zonnesoft.calculator.backend.FibonacciRequest
import com.zonnesoft.calculator.backend.ReactorCalculatorServiceGrpc
import com.zonnesoft.calculator.backend.SumReply
import com.zonnesoft.calculator.backend.SumRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.inject.Singleton

@Singleton
class CalculatorService(
    private val client: ReactorCalculatorServiceGrpc.ReactorCalculatorServiceStub
) {
    fun sum(a: Int, b: Int): Mono<Int> {
        return client.sum(SumRequest.newBuilder().setA(a).setB(b).build()).map(SumReply::getResult)
    }

    fun fibonacci(n: Int): Flux<Pair<Int, Int>> {
        return client.fibonacci(FibonacciRequest.newBuilder().setMin(0).setMax(n).build()).map {
            Pair(it.x, it.fibX)
        }
    }
}
