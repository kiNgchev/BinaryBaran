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

package net.kingchev.shared.telegram.utils

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.api.message.SendMessageAction
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.utils.builders.EntitiesCtxBuilder

/**
 * Sends message with error handler
 */
public suspend fun sendMessageWEH(update: MessageUpdate,
                                  client: TelegramBot,
                                  block: EntitiesCtxBuilder<SendMessageAction>.() -> String) {
    return try {
        sendMessage {

            block()

        }.markdown().send(update.message.chat, client)
    } catch (e: Exception) {
        sendMessage { e.message.toString() }
            .send(update.message.chat, client)
    }
}