/*
 * BinaryBaran
 * Copyright (C) 2025 Evgeny K.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import net.kingchev.shared.telegram.utils.appendEscaped
import net.kingchev.shared.telegram.utils.link
import net.kingchev.shared.telegram.utils.markdown
import java.util.concurrent.ThreadLocalRandom

@CommonHandler.Regex("сиськи", options = [RegexOption.IGNORE_CASE])
public suspend fun tits(update: MessageUpdate, user: User, client: TelegramBot) {
    val username = user.link

    val message = buildString {
        append(username)
        appendEscaped(", красивые и огромные СИСЬКИ!")
    }

    sendMessage { message }
        .markdown()
        .send(update.message.chat, client)
}

@CommonHandler.Regex("письки", options = [RegexOption.IGNORE_CASE])
public suspend fun penis(update: MessageUpdate, user: User, client: TelegramBot) {

    val username = user.link
    val message = buildString {
        append(username)
        appendEscaped(", красивые ПИСЬКИ!")

        val rnd = ThreadLocalRandom.current().nextInt(1,100)

        if (rnd <= 50) {
            // todo: random user from db cache (maybe)
            appendEscaped("\nНе шовел как у NuclearMyraBey ")
        }
    }

    sendMessage { message }
        .markdown()
        .send(update.message.chat, client)
}