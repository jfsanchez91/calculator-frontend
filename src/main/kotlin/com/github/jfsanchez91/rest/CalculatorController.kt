package com.github.jfsanchez91.rest

import com.github.jfsanchez91.rest.dto.FibonacciResponse
import com.github.jfsanchez91.rest.dto.SumResponse
import com.github.jfsanchez91.service.CalculatorService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Controller("/api/v1/")
class CalculatorController(
    private val calculatorService: CalculatorService
) {
    @Get("/sum/{a}/{b}")
    fun sum(@PathVariable("a") a: Int, @PathVariable("b") b: Int): Mono<SumResponse> {
        return calculatorService.sum(a, b).map { SumResponse(a, b, it) }
    }

    @Get("/fib/{n}")
    fun fibonacci(@PathVariable("n") n: Int): Flux<FibonacciResponse> {
        return calculatorService.fibonacci(n).delayElements(Duration.ofMillis(100)).map { FibonacciResponse(it.first, it.second) }
    }
}
