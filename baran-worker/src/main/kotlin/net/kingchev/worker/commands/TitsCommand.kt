package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate

@CommonHandler.Regex("сиськи", options = [RegexOption.IGNORE_CASE])
public suspend fun tits(update: MessageUpdate, user: User, client: TelegramBot) {
    var username = user.username;
    if (username.isNullOrEmpty()) {
        username = "[даун](${user.id})"
    } else {
        username.apply { "@" }
    }

    sendMessage { "${username}, огромные СИСЬКИ" }.send(update.message.chat, client)
}