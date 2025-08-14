/*
* СПИСОК КОМАНД:
* Отсос
* Пригласить на чай
* Пригласить на кофе
* Отдаться
* Съесть
* Отпиздить питоняшку
* */

package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.annotations.ParamMapping
import eu.vendeli.tgbot.annotations.UpdateHandler
import eu.vendeli.tgbot.api.message.message
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.UpdateType
import org.mapstruct.control.MappingControl.Use


//@UpdateHandler([UpdateType.MESSAGE])
//public suspend fun blowjob(update: MessageUpdate, user: User, client: TelegramBot) {
//    if (!update.text.startsWith("отсосать", true)) return
//    val args = update.text.split(" ")
//    if (args.size < 2)
//        return sendMessage { "Кому отсосать хочешь?" }.send(update.message.chat, client)
//
//    val target = args[1]
//
//    sendMessage { "@${user.username} отсосал $target" }.send(update.message.chat, client)
//}



@CommandHandler(["отсос"])
public suspend fun blowjob(update: MessageUpdate, user: User, client: TelegramBot) {
    sendMessage{"@${user.username} пустили по кругу!"}.send(update.message.chat, client)
}



