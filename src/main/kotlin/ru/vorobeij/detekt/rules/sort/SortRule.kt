package ru.vorobeij.detekt.rules.sort

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Severity
import io.gitlab.arturbosch.detekt.api.internal.ActiveByDefault
import io.gitlab.arturbosch.detekt.api.internal.AutoCorrectable
import io.gitlab.arturbosch.detekt.formatting.FormattingRule

@ActiveByDefault(since = "1.0.0")
@AutoCorrectable(since = "1.0.0")
class SortRule(config: Config) : FormattingRule(config) {

    override val issue = Issue(
        javaClass.simpleName,
        Severity.Style,
        "Sort file internals",
        Debt.FIVE_MINS,
    )
    override val wrapping = SortFormatRule()
}
