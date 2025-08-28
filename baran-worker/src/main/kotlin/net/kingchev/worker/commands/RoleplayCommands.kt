/*
 *     BinaryBaran
 *     Copyright (C) 2025 kiNgchev, NuclearMyraBey, Evgeny K.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/*
* СПИСОК КОМАНД:
* Отсос
* */

package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.UpdateType
import net.kingchev.shared.telegram.utils.getReplyUserLink
import net.kingchev.shared.telegram.utils.link
import net.kingchev.shared.telegram.utils.sendMessageWEH

// TODO: parse args
@CommandHandler(["отсосать"], scope = [UpdateType.MESSAGE])
public suspend fun blowjob(update: MessageUpdate, user: User, client: TelegramBot) {
    val author = user.link

    val value = "себе"

    val purpose = getReplyUserLink(
        update.message.replyToMessage,
        user,
        value
    )

    sendMessageWEH(update, client) { "$author отсосал $purpose" }
}

// TODO: parse args
@CommandHandler(["обнять"], scope = [UpdateType.MESSAGE])
public suspend fun hugs(update: MessageUpdate, user: User, client: TelegramBot) {
    val author = user.link

    val value = "себя"

    val purpose = getReplyUserLink(
        update.message.replyToMessage,
        user,
        value
    )

    sendMessageWEH(update, client) { "$author обнял $purpose" }
}