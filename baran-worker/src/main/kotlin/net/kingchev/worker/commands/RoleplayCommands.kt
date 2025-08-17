/*
 *     BinaryBaran
 *     Copyright (C) 2025 kiNgchev, NuclearMyraBey
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
import eu.vendeli.tgbot.annotations.ArgParser
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.api.message.sendMessage
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.UpdateType
import net.kingchev.shared.telegram.BaranArgParser
import net.kingchev.shared.telegram.utils.link
import net.kingchev.shared.telegram.utils.markdown

@ArgParser(BaranArgParser::class)
@CommonHandler.Regex("отсос", scope = [UpdateType.MESSAGE])
public suspend fun blowjob(param1: String, update: MessageUpdate, user: User, client: TelegramBot) {
    val author = user.link
    sendMessage { "$author отсосал $param1" }
        .markdown()
        .send(update.message.chat, client)
}