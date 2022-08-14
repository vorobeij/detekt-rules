package ru.vorobeij.detekt.rules.sort

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Severity
import io.gitlab.arturbosch.detekt.formatting.FormattingRule

class SortRule(config: Config) : FormattingRule(config) {

    override val issue = Issue(
        javaClass.simpleName,
        Severity.Style,
        "Sort file internals",
        Debt.FIVE_MINS,
    )
    override val wrapping = SortFormatRule()
}
