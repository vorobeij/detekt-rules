package ru.vorobeij.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.formatting.wrappers.AnnotationOnSeparateLine
import io.gitlab.arturbosch.detekt.formatting.wrappers.AnnotationSpacing
import io.gitlab.arturbosch.detekt.formatting.wrappers.ArgumentListWrapping
import io.gitlab.arturbosch.detekt.formatting.wrappers.BlockCommentInitialStarAlignment
import io.gitlab.arturbosch.detekt.formatting.wrappers.CommentWrapping
import io.gitlab.arturbosch.detekt.formatting.wrappers.DiscouragedCommentLocation
import io.gitlab.arturbosch.detekt.formatting.wrappers.EnumEntryNameCase
import io.gitlab.arturbosch.detekt.formatting.wrappers.FunctionTypeReferenceSpacing
import io.gitlab.arturbosch.detekt.formatting.wrappers.FunKeywordSpacing
import io.gitlab.arturbosch.detekt.formatting.wrappers.KdocWrapping
import io.gitlab.arturbosch.detekt.formatting.wrappers.ModifierListSpacing
import io.gitlab.arturbosch.detekt.formatting.wrappers.MultiLineIfElse
import io.gitlab.arturbosch.detekt.formatting.wrappers.NoEmptyFirstLineInMethodBlock
import io.gitlab.arturbosch.detekt.formatting.wrappers.PackageName
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundAngleBrackets
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundDoubleColon
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingAroundUnaryOperator
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingBetweenDeclarationsWithAnnotations
import io.gitlab.arturbosch.detekt.formatting.wrappers.SpacingBetweenDeclarationsWithComments
import io.gitlab.arturbosch.detekt.formatting.wrappers.TrailingComma
import io.gitlab.arturbosch.detekt.formatting.wrappers.TypeArgumentListSpacing
import io.gitlab.arturbosch.detekt.formatting.wrappers.UnnecessaryParenthesesBeforeTrailingLambda

/**
 * Wrappers for ktlint-ruleset-experimental rules. Disabled by default.
 */
internal fun experimentalRules(config: Config) = arrayOf(
    AnnotationOnSeparateLine(config),
    AnnotationSpacing(config),
    ArgumentListWrapping(config),
    BlockCommentInitialStarAlignment(config),
    CommentWrapping(config),
    DiscouragedCommentLocation(config),
    EnumEntryNameCase(config),
    FunctionTypeReferenceSpacing(config),
    FunKeywordSpacing(config),
    KdocWrapping(config),
    ModifierListSpacing(config),
    MultiLineIfElse(config),
    NoEmptyFirstLineInMethodBlock(config),
    PackageName(config),
    SpacingAroundAngleBrackets(config),
    SpacingAroundDoubleColon(config),
    SpacingAroundUnaryOperator(config),
    SpacingBetweenDeclarationsWithAnnotations(config),
    SpacingBetweenDeclarationsWithComments(config),
    TrailingComma(config),
    TypeArgumentListSpacing(config),
    UnnecessaryParenthesesBeforeTrailingLambda(config),
)
