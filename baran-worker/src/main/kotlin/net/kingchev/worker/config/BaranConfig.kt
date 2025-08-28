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

package net.kingchev.worker.config

import eu.vendeli.tgbot.TelegramBot
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.kingchev.shared.telegram.BaranClassManager
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["net.kingchev"])
@EnableConfigurationProperties(BaranProperties::class)
public class BaranConfig(private val props: BaranProperties) {
    @OptIn(DelicateCoroutinesApi::class) // idea
    @Bean
    public fun baranClient(classManager: BaranClassManager): TelegramBot {
        val bot = TelegramBot(props.token)
        {
            identifier = "baran-bot"
            this.classManager = classManager
            //throwExOnActionsFailure = true
        }

        GlobalScope.launch { bot.handleUpdates() }
        return bot
    }
}
