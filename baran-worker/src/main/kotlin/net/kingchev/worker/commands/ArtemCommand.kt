package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.UpdateType

@CommonHandler.Regex("[А, а]рт[е, ё]м", scope = [UpdateType.MESSAGE])
public suspend fun artem(update: MessageUpdate, user: User, client: TelegramBot) {
    sendMessage { "артем" }.send(update.message.chat, client)
}

@CommonHandler.Regex("[Г, г]ойда", scope = [UpdateType.MESSAGE])
public suspend fun goida(update: MessageUpdate, user: User, client: TelegramBot) {
    sendMessage { "ГОЙДА ZOV ZOV ZZZ ZOV 333 ZA НАШИХ\nКРЫМ РОZZИИ" }.send(update.message.chat, client)
}