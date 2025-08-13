package net.kingchev.worker

import net.kingchev.worker.config.BaranConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(BaranConfig::class)
public class BinaryBaranWorker

public fun main(args: Array<String>) {
    runApplication<BinaryBaranWorker>(*args)
}