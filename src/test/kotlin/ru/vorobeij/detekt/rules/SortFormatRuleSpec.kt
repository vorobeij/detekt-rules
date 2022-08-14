package ru.vorobeij.detekt.rules

import org.junit.jupiter.api.Test
import ru.vorobeij.detekt.config.FormatAllConfig
import ru.vorobeij.detekt.rules.sort.SortRule
import ru.vorobeij.detekt.utils.formatAndCompare
import ru.vorobeij.detekt.utils.loadFileContent

class SortFormatRuleSpec {

    @Test
    fun `should sort file contents`() {
        SortRule(FormatAllConfig()).formatAndCompare(
            input = loadFileContent("sort/input.kt"),
            expected = loadFileContent("sort/output.kt")
        )
    }
}
