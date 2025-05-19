package net.kingchev.binarybaran.component

import net.kingchev.binarybaran.command.AbstractCommand
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CommandHandler {
    private val commands: HashMap<String, AbstractCommand> = HashMap()

    @Autowired
    fun registerCommands(list: List<AbstractCommand>) {
        list.forEach {
            val data = it.data

            if (this.commands[data.key] != null) {
                log.error("Command with key `${data.key}` already exists!")
                return@forEach
            }

            this.commands[data.key] = it
            log.info("Command `${data.key}` successfully loaded!")
        }
    }

    fun getCommand(key: String): AbstractCommand =
        this.commands[key] ?: throw IllegalArgumentException("Unknown key `$key`")

    companion object {
        private val log = LoggerFactory.getLogger(CommandHandler::class.java)
    }
}