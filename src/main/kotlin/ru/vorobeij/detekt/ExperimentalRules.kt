package ru.vorobeij.detekt

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
