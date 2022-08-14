package ru.vorobeij.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class VorobeijRuleSetProvider : RuleSetProvider {

    override val ruleSetId: String = "VorobeijRuleSet"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(
                *customRules(config),
                *standardRules(config),
                *experimentalRules(config)
            ),
        )
    }
}
