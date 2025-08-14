/*
* СПИСОК КОМАНД:
* Отсос
* */

package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.UpdateHandler
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.UpdateType

@UpdateHandler([UpdateType.MESSAGE])
public suspend fun blowjob(update: MessageUpdate, user: User, client: TelegramBot) {
    if (!update.text.startsWith("отсосать", true)) return
    val args = update.text.split(" ")
    if (args.size < 2)
        return sendMessage { "Кому отсосать хочешь?" }.send(update.message.chat, client)

    val target = args[1]

    sendMessage { "@${user.username} отсосал $target" }.send(update.message.chat, client)
}

