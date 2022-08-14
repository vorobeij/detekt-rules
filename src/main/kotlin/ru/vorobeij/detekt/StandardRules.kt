package ru.vorobeij.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.formatting.wrappers.ChainWrapping
import io.gitlab.arturbosch.detekt.formatting.wrappers.CommentSpacing
import io.gitlab.arturbosch.detekt.formatting.wrappers.Filename
import io.gitlab.arturbosch.detekt.formatting.wrappers.FinalNewline
import io.gitlab.arturbosch.detekt.formatting.wrappers.ImportOrdering
import io.gitlab.arturbosch.detekt.formatting.wrappers.Indentation
import io.gitlab.arturbosch.detekt.formatting.wrappers.MaximumLineLength
import io.gitlab.arturbosch.detekt.formatting.wrappers.ModifierOrdering
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoBlankLineBeforeRbrace
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoConsecutiveBlankLines
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoEmptyClassBody
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoLineBreakAfterElse
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoLineBreakBeforeAssignment
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoMultipleSpaces
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoSemicolons
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoTrailingSpaces
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoUnitReturn
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoUnusedImports
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoWildcardImports
import io.gitlab.arturbosch.detekt.formatting.wrappers.ParameterListWrapping
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundColon
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundComma
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundCurly
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundDot
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundKeyword
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundOperators
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundParens
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundRangeOperator
import io.gitlab.arturbosch.detekt.formatting.wrappers.StringTemplate
import io.gitlab.arturbosch.detekt.formatting.wrappers.Wrapping

/**
 * Wrappers for ktlint-ruleset-standard rules. Enabled by default.
 */
internal fun standardRules(config: Config) = arrayOf(
    ChainWrapping(config),
    CommentSpacing(config),
    Filename(config),
    FinalNewline(config),
    ImportOrdering(config),
    Indentation(config),
    MaximumLineLength(config),
    ModifierOrdering(config),
    NoBlankLineBeforeRbrace(config),
    NoConsecutiveBlankLines(config),
    NoEmptyClassBody(config),
    NoLineBreakAfterElse(config),
    NoLineBreakBeforeAssignment(config),
    NoMultipleSpaces(config),
    NoSemicolons(config),
    NoTrailingSpaces(config),
    NoUnitReturn(config),
    NoUnusedImports(config),
    NoWildcardImports(config),
    ParameterListWrapping(config),
    SpacingAroundColon(config),
    SpacingAroundComma(config),
    SpacingAroundCurly(config),
    SpacingAroundDot(config),
    SpacingAroundKeyword(config),
    SpacingAroundOperators(config),
    SpacingAroundParens(config),
    SpacingAroundRangeOperator(config),
    StringTemplate(config),
    Wrapping(config)
)
