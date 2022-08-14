import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    `maven-publish`
}

group = "ru.vorobeij.detekt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val detekt = "1.21.0"
    implementation("io.gitlab.arturbosch.detekt:detekt-api:$detekt")
    implementation("io.gitlab.arturbosch.detekt:detekt-formatting:$detekt")

    val ktlint = "0.46.1"
    implementation("com.pinterest.ktlint:ktlint-core:${ktlint}")
    implementation("com.pinterest.ktlint:ktlint-ruleset-standard:${ktlint}")
    testImplementation("com.pinterest.ktlint:ktlint-test:${ktlint}")

    testImplementation("io.gitlab.arturbosch.detekt:detekt-test:1.21.0")
    testImplementation("io.kotest:kotest-assertions-core:5.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_class")
    systemProperty("compile-snippet-tests", project.hasProperty("compile-test-snippets"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
