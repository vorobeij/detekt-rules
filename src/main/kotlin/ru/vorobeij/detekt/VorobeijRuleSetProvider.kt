package ru.vorobeij.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider
import ru.vorobeij.detekt.rules.sort.SortRule

class VorobeijRuleSetProvider : RuleSetProvider {

    override val ruleSetId: String = "rules-vorobeij"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(
                SortRule(config)
            )
        )
    }
}
