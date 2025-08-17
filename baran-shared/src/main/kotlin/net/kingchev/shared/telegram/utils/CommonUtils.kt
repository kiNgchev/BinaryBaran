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

import eu.vendeli.tgbot.types.User

public fun getUsername(user: User): StringBuilder {
    val username = StringBuilder(user.username ?: "")

    if (username.isEmpty()) {
        username.append("[даун](tg://user?id=${user.id})")
    } else {
        // [name](tg://user?id=123123)
        username.insert(0, "[")
        username.append("]")
        username.append("(tg://user?id=${user.id})")
    }

    return username
}