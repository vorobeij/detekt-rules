package ru.vorobeij.detekt.config

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.ConfigAware
import io.gitlab.arturbosch.detekt.api.RuleId
import io.gitlab.arturbosch.detekt.test.TestConfig

class FormatAllConfig : TestConfigAware(Config.AUTO_CORRECT_KEY to true)

open class TestConfigAware(private vararg val data: Pair<String, Any>) : ConfigAware {
    override val ruleId: RuleId
        get() = "test"
    override val ruleSetConfig: Config
        get() = TestConfig(data.toMap())
}
