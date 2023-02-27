package com.inalegwu.checkbook

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import java.nio.charset.StandardCharsets


@Controller
@CrossOrigin(origins = ["*"])
@RequestMapping(value = ["/api/checkbook"])
class CheckbookController(private val checkbookService: CheckbookService) {

    @PostMapping("/compute")
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        val text = checkbookService.computeDepositWithdraw(file)
        return ResponseEntity.ok().body(text)
    }
}