package ru.vorobeij.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider
import ru.vorobeij.detekt.rules.MyRule
import ru.vorobeij.detekt.rules.sort.SortRule

class VorobeijRuleSetProvider : RuleSetProvider {

    override val ruleSetId: String = "VorobeijRuleSet"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(
                MyRule(config),
                SortRule(config),
            ),
        )
    }
}
