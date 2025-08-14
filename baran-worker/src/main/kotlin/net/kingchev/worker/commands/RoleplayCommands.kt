/*
* СПИСОК КОМАНД:
*
* */

package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.UpdateType

@CommonHandler.Regex("[О, о]тсосать @([\\w]+)", scope = [UpdateType.MESSAGE])
public suspend fun blowjob(update: MessageUpdate, user: User, client: TelegramBot) {
    val matchRes = update.message.text?.let { Regex("[О, о]тсосать @([\\w]+)").find(it) }!!

    val username = matchRes.groupValues[1]
    sendMessage { "@${user.username} отсосал @$username" }.send(update.message.chat, client)
}

