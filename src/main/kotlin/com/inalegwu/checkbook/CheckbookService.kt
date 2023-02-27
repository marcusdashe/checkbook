package com.inalegwu.checkbook

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.charset.StandardCharsets


@Service
class CheckbookService {

    fun computeDepositWithdraw(f: MultipartFile): String {
        var balance  = 0.0
        val lines = String(f.bytes, StandardCharsets.UTF_8).lines().toMutableList()
        val builder = StringBuilder()

        while (lines.isNotEmpty()) {
            val operation = lines.removeAt(0)
            if(operation == "deposit") {
                val amount = lines.removeAt(0).toDouble()
                balance += amount
            } else if (operation == "withdraw") {
                val amount = lines.removeAt(0).toDouble()
                balance -= amount
            } else {
                throw IllegalArgumentException("Invalid operation: $operation")
            }
            val roundedValue = String.format("%.2f", balance)
            builder.appendLine("Balance: $roundedValue")
        }
        return builder.toString()
    }
}