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
        val text = "JavaText"
        val code = "JavaCode"
        val instructions = "JavaInstructions"

        return GeneratingResult(text, code, instructions)
    }
}
