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
import eu.vendeli.tgbot.types.component.MessageUpdate
import eu.vendeli.tgbot.types.component.ParseMode
import eu.vendeli.tgbot.types.msg.Message
import eu.vendeli.tgbot.types.options.Options
import eu.vendeli.tgbot.types.options.OptionsParseMode

public val User.link: String
    get() = getUserLink(this)

public fun getUserLink(user: User): String {
    val fullName = if (user.lastName != null) " ${user.firstName} ${user.lastName}" else user.firstName

    return buildString {
        append("[$fullName](tg://user?id=${user.id})")
    }
}

/**
 * Gets the user being replied to.
 *
 * If `replyMessage` is null, returns null.
 * Otherwise, returns the sender of `replyMessage`.
 * If the sender is null or the same as `user`, returns `user`.
 *
 * @param replyMessage The message being replied to. Null if not a reply.
 * @param user The user who sent the original message.
 * @return The user being replied to, or null if there is no reply.
 */
public fun getReplyUser(replyMessage: Message?,
                        user: User) : User? {
    val isReply = replyMessage != null

    var replyToUser: User? = null

    if (isReply) {
        val replySender = replyMessage.from ?: user
        replyToUser = if (replySender.id == user.id) user else replySender
    }

    return replyToUser
}


/**
 * Gets the purpose string for a reply message.
 *
 * If `replyMessage` is not a reply to another user, returns `default`.
 * Otherwise, returns a link to the user being replied to.
 *
 * @param replyMessage The message being replied to. Null if not a reply.
 * @param user The user who sent the original message.
 * @param default The default value to return if not replying to another user.
 * @return Link to the replied user or default value if not applicable.
 */
public fun getReplyUserLink(replyMessage: Message?,
                        user: User,
                        default: String) : String? {

    val replier = if (getReplyUser(replyMessage, user) == null) {
        user
    } else {
        getReplyUser(replyMessage, user)
    }

    val purpose: String? = if (replier == user) {
        default
    } else {
        replier!!.link
    }

    return purpose
}

@Suppress("NOTHING_TO_INLINE")
public inline fun <T, R, O> T.markdown(crossinline block: O.() -> Unit = {}): T
where T : TgAction<R>, T : OptionsFeature<T, O>, O : Options, O : OptionsParseMode =
    options {
        parseMode = ParseMode.Markdown
        block()
    }

@Suppress("NOTHING_TO_INLINE")
public inline fun <T, R, O> T.markdownV2(crossinline block: O.() -> Unit = {}): T
        where T : TgAction<R>, T : OptionsFeature<T, O>, O : Options, O : OptionsParseMode =
    options {
        parseMode = ParseMode.MarkdownV2
        block()
    }

@Suppress("NOTHING_TO_INLINE")
public inline fun <T, R, O> T.html(crossinline block: O.() -> Unit = {}): T
where T : TgAction<R>, T : OptionsFeature<T, O>, O : Options, O : OptionsParseMode =
    options {
        parseMode = ParseMode.HTML
        block()
    }