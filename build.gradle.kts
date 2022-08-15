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

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.dokka")
    apply(plugin = "signing")

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = JVM_TARGET.toString()
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = JVM_TARGET.toString()
        }
    }

    val dokkaHtml by tasks.existing(DokkaTask::class)

    val dokkaJar by tasks.creating(org.gradle.jvm.tasks.Jar::class) {
        group = JavaBasePlugin.DOCUMENTATION_GROUP
        archiveClassifier.set("javadoc")
        from(dokkaHtml)
    }

    val sourcesJar by tasks.creating(org.gradle.jvm.tasks.Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    val pomArtifactId: String? by project
    if (pomArtifactId != null) {
        publishing {
            publications {
                create<MavenPublication>("mavenJava") {
                    val versionName: String by project
                    val pomGroupId: String by project
                    groupId = pomGroupId
                    artifactId = pomArtifactId
                    version = versionName
                    from(components["java"])

                    artifact(dokkaJar)
                    artifact(sourcesJar)

                    pom {
                        val pomDescription: String by project
                        val pomUrl: String by project
                        val pomName: String by project
                        description.set(pomDescription)
                        url.set(pomUrl)
                        name.set(pomName)

                        licenses {
                            license {
                                val pomLicenseName: String by project
                                val pomLicenseUrl: String by project
                                val pomLicenseDist: String by project
                                name.set(pomLicenseName)
                                url.set(pomLicenseUrl)
                                distribution.set(pomLicenseDist)
                            }
                        }
                        developers {
                            developer {
                                val pomDeveloperId: String by project
                                val pomDeveloperName: String by project
                                id.set(pomDeveloperId)
                                name.set(pomDeveloperName)
                            }
                        }
                    }
                }
            }
            signing {
                sign(publishing.publications["mavenJava"])
            }
            repositories {
                maven {
                    val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                    val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
                    val versionName: String by project
                    url = if (versionName.endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
                    credentials {
                        username = project.findProperty("NEXUS_USERNAME")?.toString()
                        password = project.findProperty("NEXUS_PASSWORD")?.toString()
                    }
                }
            }
        }
    }
}
