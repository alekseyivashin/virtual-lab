package vlab.server_java.check

import rlcp.check.ConditionForChecking
import rlcp.generate.GeneratingResult
import rlcp.server.processor.check.CheckProcessor
import rlcp.server.processor.check.PreCheckProcessor
import rlcp.server.processor.check.PreCheckProcessor.PreCheckResult
import rlcp.server.processor.check.PreCheckResultAwareCheckProcessor

import java.math.BigDecimal

/**
 * Simple CheckProcessor implementation. Supposed to be changed as needed to provide
 * necessary Check method support.
 */
class CheckProcessorImpl : PreCheckResultAwareCheckProcessor<String> {
    @Throws(Exception::class)
    override fun checkSingleCondition(
            condition: ConditionForChecking,
            instructions: String,
            generatingResult: GeneratingResult
    ): CheckProcessor.CheckingSingleConditionResult {
        var points = BigDecimal.ZERO
        var comment = ""

        val initNumbersList = parseJsonArray(generatingResult.code)
        val values = parseJsonArray(instructions)

        val correctValues = calculateCorrectValues(Pair(initNumbersList[0], initNumbersList[1]))

        val correct = correctValues == values

        if (correct) points = BigDecimal.ONE

        return CheckProcessor.CheckingSingleConditionResult(points, comment)
    }

    override fun setPreCheckResult(preCheckResult: PreCheckResult<String>) {}

    private fun parseJsonArray(array: String): List<Int> {
        return array.removeSurrounding("[", "]").split(",").map { it.trim().toInt() }
    }

    private fun calculateCorrectValues(initNumbers: Pair<Int, Int>): List<Int> {
        val values = mutableListOf<Int>()
        var first = initNumbers.first
        var second = initNumbers.second
        while (second != 0) {
            val result = first - second
            values.add(result)
            if (result < second) {
                first = second
                second = result
            } else {
                first = result
            }
        }
        return values
    }
}
