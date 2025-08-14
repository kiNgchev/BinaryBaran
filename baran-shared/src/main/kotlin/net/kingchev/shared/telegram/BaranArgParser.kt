package net.kingchev.shared.telegram

import eu.vendeli.tgbot.interfaces.helper.ArgumentParser

public object BaranArgParser : ArgumentParser {
    override fun parse(text: String): Map<String, String> {
        var index = 1
        val result = mutableMapOf<String, String>()
        text.split(" ").forEach { arg ->
            result["param$index"] = arg
            index++
        }
        return result
    }
}