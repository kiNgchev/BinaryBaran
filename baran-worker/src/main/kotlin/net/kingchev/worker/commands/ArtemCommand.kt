package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.UpdateType

@CommonHandler.Regex("арт[е, ё]м", options = [RegexOption.IGNORE_CASE])
public suspend fun artem(update: MessageUpdate, user: User, client: TelegramBot) {
    sendMessage { "артем" }.send(update.message.chat, client)
}

@CommonHandler.Regex("чей крым?", options = [RegexOption.IGNORE_CASE], scope = [UpdateType.MESSAGE])
public suspend fun krim(update: MessageUpdate, user: User, client: TelegramBot) {
    sendMessage { "Крым — русский" }.send(update.message.chat, client)
}

// Гойда
@CommonHandler.Regex("гойда", options = [RegexOption.IGNORE_CASE], scope = [UpdateType.MESSAGE])
public suspend fun goida(update: MessageUpdate, user: User, client: TelegramBot) {
    val slogans = listOf(
        "Слышу ZOV ебать Азов",
        "Крым — русский",
        "Слава России!",
        "За Веру, Царя и Отечество — с нами Бог",
        "Слава российскому оружию"
    )
    sendMessage { slogans.random() }.send(update.message.chat, client)
}