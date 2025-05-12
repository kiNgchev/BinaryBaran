package net.kingchev.binarybaran.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "baran")
data class CommonProperties(
    val token: String
)