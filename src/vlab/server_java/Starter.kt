package vlab.server_java

import org.springframework.context.support.GenericXmlApplicationContext
import rlcp.RlcpResponseBody
import rlcp.server.Server
import rlcp.server.processor.factory.ProcessorFactoryContainer

import java.io.File

/**
 * Main class for RLCP-server starting.
 */
object Starter {

    /**
     * Defines applicable logic modules, configuration path and starts RLCP-server
     */
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val context = GenericXmlApplicationContext()
        context.load("classpath:vlab/server_java/java-server-config.xml")
        context.refresh()
        if (args.isEmpty()) {
            Thread(context.getBean("server", Server::class.java)).start()
        } else {
            val consoleStarter = vlab.ConsoleStarter()
            val responseBody = consoleStarter.runConsoleServer(File(args[0]), context.getBean("container", ProcessorFactoryContainer::class.java))
            println(responseBody)
        }
    }


}