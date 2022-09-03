package br.com.fiap.credito

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CreditoApplication

fun main(args: Array<String>) {
	runApplication<CreditoApplication>(*args)
}
