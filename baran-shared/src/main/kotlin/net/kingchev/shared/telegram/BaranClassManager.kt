package net.kingchev.shared.telegram

import eu.vendeli.tgbot.interfaces.ctx.ClassManager
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
public class BaranClassManager(public val context: ApplicationContext) : ClassManager {
    override fun getInstance(kClass: KClass<*>, vararg initParams: Any?): Any {
        kClass.objectInstance?.also { return it }
        return context.getBean(kClass.java, *initParams)
    }
}