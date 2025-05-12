package net.kingchev.binarybaran

import net.kingchev.binarybaran.config.CommonConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(CommonConfig::class)
class BinaryBaranApplication

fun main(args: Array<String>) {
    runApplication<BinaryBaranApplication>(*args)
}
