/*
 *     BinaryBaran
 *     Copyright (C) 2025 kiNgchev
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

package net.kingchev.shared.telegram.utils

import eu.vendeli.tgbot.interfaces.action.TgAction
import eu.vendeli.tgbot.interfaces.features.OptionsFeature
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.component.ParseMode
import eu.vendeli.tgbot.types.options.Options
import eu.vendeli.tgbot.types.options.OptionsParseMode

public val User.link: String
    get() = getUsername(this)

public fun getUsername(user: User): String {
    val fullName = if (user.lastName != null) " ${user.firstName} ${user.lastName}" else user.firstName
    val username = StringBuilder(user.username ?: "")

    if (username.isEmpty()) {
        username.append("[$fullName](tg://user?id=${user.id})")
    } else {
        // [name](tg://user?id=123123)
        username.insert(0, "[")
        username.append("]")
        username.append("(tg://user?id=${user.id})")
    }

    return username.toString()
}

@Suppress("NOTHING_TO_INLINE")
public inline fun <T, R, O> T.markdown(crossinline block: O.() -> Unit = {}): T
where T : TgAction<R>, T : OptionsFeature<T, O>, O : Options, O : OptionsParseMode =
    options {
        parseMode = ParseMode.Markdown
        block()
    }

@Suppress("NOTHING_TO_INLINE")
public inline fun <T, R, O> T.html(crossinline block: O.() -> Unit = {}): T
where T : TgAction<R>, T : OptionsFeature<T, O>, O : Options, O : OptionsParseMode =
    options {
        parseMode = ParseMode.HTML
        block()
    }