[![](https://jitpack.io/v/vorobeij/detekt-rules.svg)](https://jitpack.io/#vorobeij/detekt-rules)

> Based on https://detekt.dev gradle plugin

# Setup

Setup default [detekt rules](https://github.com/detekt/detekt)

Add to your root `build.gradle` at the end of repositories:

```kotlin
allprojects {
    repositories {
        maven(url = "https://jitpack.io")
    }
}
```

```kotlin
dependencies {
    detektPlugins("com.github.vorobeij:detekt-rules:master-SNAPSHOT")
}
```

Add config to your `detekt-config.yml`

```yml
rules-vorobeij:
    active: false
    SortRule:
        active: true
    kotlin-sort:
        active: true
```

## Gradle tasks

- detekt
- detektFormat
