package net.kingchev.worker.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "baran")
public data class BaranProperties(
    val token: String,
    val username: String = "@binarybaran_bot"
)