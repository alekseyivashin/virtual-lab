package vlab

import rlcp.Rlcp
import rlcp.RlcpRequestBody
import rlcp.RlcpResponseBody
import rlcp.exception.BadRlcpBodyException
import rlcp.server.ServerMethod
import rlcp.server.flow.RlcpRequestFlow
import rlcp.server.processor.factory.ProcessorFactoryContainer

import java.io.BufferedReader
import java.io.File
import java.nio.CharBuffer
import java.nio.file.Files
import java.nio.file.Path

class ConsoleStarter {

    fun runConsoleServer(request: File, container: ProcessorFactoryContainer): RlcpResponseBody? {
        val rawRequest = readFile(request.toPath())
        try {
            val rlcpRequestBody = Rlcp.parseRequestBody(rawRequest)
            runConsoleServer(rlcpRequestBody, container)
        } catch (e: BadRlcpBodyException) {
            e.printStackTrace()
        }

        return null
    }


    fun runConsoleServer(rlcpRequestBody: RlcpRequestBody, container: ProcessorFactoryContainer): RlcpResponseBody {
        var flow: RlcpRequestFlow? = null
        println(rlcpRequestBody.method.name)
        when (rlcpRequestBody.method.name.toLowerCase()) {
            "generate" -> flow = ServerMethod.GENERATE.flow
            "check" -> flow = ServerMethod.CALCULATE.flow
            "calculate" -> flow = ServerMethod.CHECK.flow
        }

        return flow!!.processBody(container, rlcpRequestBody)
    }

    private fun readFile(p: Path): String {
        var rawRequest = ""
        try {
            val rawRequestBuilder = StringBuilder()
            val charBuffer = CharBuffer.allocate(Files.size(p).toInt())
            val br = Files.newBufferedReader(p)
            while (br.ready()) {
                br.read(charBuffer)
                charBuffer.flip()
                rawRequestBuilder.append(charBuffer.toString())
            }
            rawRequest = rawRequestBuilder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return rawRequest
    }
}
