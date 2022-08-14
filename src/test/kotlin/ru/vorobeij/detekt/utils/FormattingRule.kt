package ru.vorobeij.detekt.utils

import com.pinterest.ktlint.core.ast.visit
import io.github.detekt.test.utils.compileContentForTest
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Finding
import io.gitlab.arturbosch.detekt.formatting.FormattingProvider
import io.gitlab.arturbosch.detekt.formatting.FormattingRule
import io.gitlab.arturbosch.detekt.test.loadRuleSet
import org.intellij.lang.annotations.Language
import org.jetbrains.kotlin.psi.KtFile
import org.junit.jupiter.api.Assertions

fun FormattingRule.lint(@Language("kotlin") content: String, fileName: String = "Test.kt"): List<Finding> {
    val root = compileContentForTest(content, fileName)
    this.visit(root)
    root.node.visit { node -> this.apply(node) }
    return this.findings
}

fun FormattingRule.format(@Language("kotlin") content: String, fileName: String = "Test.kt"): String {
    val root = compileContentForTest(content, fileName)
    visit(root)
    root.node.visit { node -> this.apply(node) }
    return root.text
}

fun FormattingRule.formatAndCompare(input: String, expected: String) {
    val formatted = format(input)
    Assertions.assertEquals(expected, formatted)
}
