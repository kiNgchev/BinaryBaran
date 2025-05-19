package net.kingchev.binarybaran.component

import net.kingchev.binarybaran.config.CommonProperties
import org.springframework.stereotype.Component
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class BaranClient(val props: CommonProperties, val handler: CommandHandler) : SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {
    override fun getBotToken(): String = props.token

    override fun getUpdatesConsumer(): LongPollingUpdateConsumer = this

    override fun consume(update: Update) {
        if (!update.hasMessage())
            return

        val args = update.message.text.split("\\s".toRegex())
        val command = try {
            handler.getCommand(args[0])
        } catch (_: IllegalArgumentException) {
            return
        }

        command.execute(update)
    }
}