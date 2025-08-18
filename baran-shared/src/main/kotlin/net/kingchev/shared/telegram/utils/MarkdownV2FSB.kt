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

public fun StringBuilder.appendEscaped(text: String): StringBuilder {
    val escapedText = escapeMarkdownV2(text)
    return append(escapedText)
}

public fun StringBuilder.appendLineEscaped(text: String): StringBuilder {
    val escapedText = escapeMarkdownV2(text)
    return appendLine(escapedText)
}

private fun escapeMarkdownV2(text: String): String {
    val specialChars = setOf('_', '*', '[', ']', '(', ')', '~', '`', '>', '#', '+', '-', '=', '|', '{', '}', '.', ',', '!')
    return buildString {
        text.forEach { char ->
            if (char in specialChars) append("\\")
            append(char)
        }
    }
}