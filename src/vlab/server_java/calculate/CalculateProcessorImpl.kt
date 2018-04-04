package vlab.server_java.calculate

import rlcp.calculate.CalculatingResult
import rlcp.generate.GeneratingResult
import rlcp.server.processor.calculate.CalculateProcessor

/**
 * Simple CalculateProcessor implementation. Supposed to be changed as needed to provide necessary Calculate method support.
 */
class CalculateProcessorImpl : CalculateProcessor {
    override fun calculate(condition: String, instructions: String, generatingResult: GeneratingResult): CalculatingResult {
        //do calculate logic here
        val text = "text"
        val code = "code"

        return CalculatingResult(text, code)
    }
}
