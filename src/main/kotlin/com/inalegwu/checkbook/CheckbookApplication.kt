package com.inalegwu.checkbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CheckbookApplication

fun main(args: Array<String>) {
	runApplication<CheckbookApplication>(*args)
}
