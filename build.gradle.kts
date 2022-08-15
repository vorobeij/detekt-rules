import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.dokka.gradle.DokkaTask

val JVM_TARGET = JavaVersion.VERSION_17

plugins {
    kotlin("jvm") version "1.7.10"
    `maven-publish`
    signing
    id("org.jetbrains.dokka") version "1.7.10"
}

val versionName: String by project
val pomGroupId: String by project
group = pomGroupId
version = versionName

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.detekt.api)
    implementation(libs.detekt.formatting)
    testImplementation(libs.detekt.test)

    implementation(libs.ktlint.core)
    implementation(libs.ktlint.ruleset.standard)
    implementation(libs.ktlint.test)
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = JVM_TARGET.toString()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_class")
    systemProperty("compile-snippet-tests", project.hasProperty("compile-test-snippets"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            val versionName: String by project
            val pomGroupId: String by project
            val pomArtifactId: String by project
            groupId = pomGroupId
            artifactId = pomArtifactId
            version = versionName

            from(components["java"])
        }
    }
}
