package vlab.server_java.generate

import rlcp.generate.GeneratingResult
import rlcp.server.processor.generate.GenerateProcessor

/**
 * Simple GenerateProcessor implementation. Supposed to be changed as needed to
 * provide necessary Generate method support.
 */
class GenerateProcessorImpl : GenerateProcessor {
    override fun generate(condition: String): GeneratingResult {
        //do Generate logic here
        val text = "Проведите поиск наибольшего общего делителя, используя алгоритм Евклида";
        val code = listOf(35, 21)
        val instructions = "JavaInstructions"

        return GeneratingResult(text, code.toString(), instructions)
    }
}
