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

public object BaranArgParser : ArgumentParser {
    override fun parse(text: String): Map<String, String> {
        var index = 0
        val result = mutableMapOf<String, String>()
        text.split(" ").forEach { arg ->
            result["param$index"] = arg
            index++
        }
        return result
    }
}