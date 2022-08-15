package ru.vorobeij.detekt.rules

import io.gitlab.arturbosch.detekt.test.yamlConfig
import org.junit.jupiter.api.Test
import ru.vorobeij.detekt.rules.sort.SortRule
import ru.vorobeij.detekt.utils.formatAndCompare
import ru.vorobeij.detekt.utils.loadFileContent

class SortFormatRuleSpec {

    @Test
    fun `should sort file contents`() {
        val config = yamlConfig("config/config.yml")
        SortRule(config).formatAndCompare(
            input = loadFileContent("sort/input.txt"),
            expected = loadFileContent("sort/output.txt")
        )
    }
}
