package net.kingchev.binarybaran.command

import net.kingchev.binarybaran.command.data.CommandData
import net.kingchev.binarybaran.command.data.CommandDataBuilder
import org.telegram.telegrambots.meta.api.objects.Update

abstract class AbstractCommand(builder: CommandDataBuilder.() -> Unit) {
    val data: CommandData = CommandDataBuilder()
        .apply(builder)
        .build()

    abstract fun execute(update: Update)
}