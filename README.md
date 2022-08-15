[![](https://jitpack.io/v/vorobeij/detekt-rules.svg)](https://jitpack.io/#vorobeij/detekt-rules)

> Based on https://detekt.dev gradle plugin

# Setup

Add it in your root build.gradle at the end of repositories:
```kotlin
allprojects {
    repositories {
        maven(url = "https://jitpack.io")
    }
}
```

```kotlin
dependencies {
    implementation("com.github.vorobeij:detekt-rules:master-SNAPSHOT")
}
```

Root build.gradle.kts

```kotlin
classpath "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.1"
apply plugin : "io.gitlab.arturbosch.detekt"
```

Module's build.gradle.kts

```kotlin
apply plugin : "io.gitlab.arturbosch.detekt"

detekt "io.gitlab.arturbosch.detekt:detekt-cli:1.17.1"
detekt project (":customRules")
```

## Config file

`config.yml`

## Gradle tasks

- detekt
- detektFormat

## Autoformatting for non committed changes

ktlint.gradle.kts

```kotlin
val ktlint: Configuration by configurations.creating
val outputDir = "${project.buildDir}/reports/ktlint/"
val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))
dependencies {
    ktlint("com.pinterest:ktlint:${Versions.ktlint}")

    ktlint(project(":ktlint"))
}
val ktlintFormat by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)
    description = "Fix Kotlin code style deviations."
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args = listOf("-F", "src/**/*.kt")
}
tasks {
    getTasksByName("clean", false).forEach {
        it.dependsOn(ktlintFormat)
    }
}
```

# Rules

1. Sort kotlin file

## Adding new rules

> todo commit hash for a new rule

All rules should be configured in config.yml and RuleSetProvider
/Users/sj/AndroidApps/detekt-ruleset/src/main/resources/config/config.yml
