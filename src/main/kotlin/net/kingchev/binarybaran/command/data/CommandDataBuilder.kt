package net.kingchev.binarybaran.command.data

class CommandDataBuilder {
    private var key: String = ""

    fun key(value: String) {
        key = value
    }

    fun build(): CommandData {
        return CommandData(key)
    }
}