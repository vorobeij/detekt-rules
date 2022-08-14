package ru.vorobeij.detekt

import io.gitlab.arturbosch.detekt.api.Config
import ru.vorobeij.detekt.rules.sort.SortRule

internal fun customRules(config: Config) = arrayOf(
    SortRule(config)
)
