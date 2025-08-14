package net.kingchev.worker.config

import eu.vendeli.tgbot.TelegramBot
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.kingchev.shared.telegram.BaranClassManager
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["net.kingchev"])
@EnableConfigurationProperties(BaranProperties::class)
public class BaranConfig(private val props: BaranProperties) {
    @Bean
    public fun baranClient(classManager: BaranClassManager): TelegramBot {
        val bot = TelegramBot(props.token)
        {
            identifier = "baran-bot"
            this.classManager = classManager
        }

        GlobalScope.launch { bot.handleUpdates() }
        return bot
    }
}
