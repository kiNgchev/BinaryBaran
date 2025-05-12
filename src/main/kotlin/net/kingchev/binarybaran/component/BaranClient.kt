package net.kingchev.binarybaran.component

import net.kingchev.binarybaran.config.CommonProperties
import org.springframework.stereotype.Component
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class BaranClient(val props: CommonProperties) : SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {
    override fun getBotToken(): String = props.token

    override fun getUpdatesConsumer(): LongPollingUpdateConsumer = this

    override fun consume(update: Update) {
        // In here we place a command handler
        TODO("Not yet implemented")
    }
}