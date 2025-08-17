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

package net.kingchev.shared.telegram.parser

import eu.vendeli.tgbot.interfaces.helper.ArgumentParser

// Reserved for future commands
public object RoleplayArgParser : ArgumentParser {
    override fun parse(text: String): Map<String, String> {
        val args = text.split(' ')
        return mutableMapOf(
            "target" to args[0],
            "reason" to args.subList(1, args.size).joinToString(" "),
        )
    }
}