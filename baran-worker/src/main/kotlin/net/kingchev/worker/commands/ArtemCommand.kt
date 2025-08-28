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

package net.kingchev.worker.commands

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommonHandler
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.UpdateType
import net.kingchev.shared.telegram.utils.sendMessageWEH

@CommonHandler.Regex("арт[её]м", options = [RegexOption.IGNORE_CASE])
public suspend fun artem(update: MessageUpdate, user: User, client: TelegramBot) {
    sendMessageWEH(update, client) { "артем" }
}

@CommonHandler.Regex("чей крым?", options = [RegexOption.IGNORE_CASE], scope = [UpdateType.MESSAGE])
public suspend fun krim(update: MessageUpdate, user: User, client: TelegramBot) {
    sendMessageWEH(update, client) { "Крым — русский" }
}

// Гойда
@CommonHandler.Regex("гойда", options = [RegexOption.IGNORE_CASE], scope = [UpdateType.MESSAGE])
public suspend fun goida(update: MessageUpdate, user: User, client: TelegramBot) {
    val slogans = listOf(
        "Слышу ZOV ебать Азов",
        "Крым — русский",
        "Слава России!",
        "За Веру, Царя и Отечество — с нами Бог",
        "Слава российскому оружию"
    )
    sendMessageWEH(update, client){ slogans.random() }
}