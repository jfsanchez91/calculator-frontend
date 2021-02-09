package com.github.jfsanchez91

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.github.jfsanchez91")
		.start()
}

