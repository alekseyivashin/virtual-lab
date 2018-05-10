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
        //do check logic here
        val points = BigDecimal(1.0)
        val comment = "it's ok"

        return CheckProcessor.CheckingSingleConditionResult(points, comment)
    }

    override fun setPreCheckResult(preCheckResult: PreCheckResult<String>) {}
}
