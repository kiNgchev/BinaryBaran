package net.kingchev.worker.commands
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

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate

@CommonHandler.Regex("сиськи", options = [RegexOption.IGNORE_CASE])
public suspend fun tits(update: MessageUpdate, user: User, client: TelegramBot) {
    val message = StringBuilder()

    val username = StringBuilder(user.username)
    if (username.isEmpty()) {
        username.append("[даун](${user.id})")
    } else {
        username.insert(0,'@')
    }

    message.append("${username}, красивые ПИСЬКИ.")

    sendMessage { message.toString() }.send(update.message.chat, client)
}