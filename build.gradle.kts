import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.SourceSet

group = "ro.jtonic.presentations"
version = "0.1.0-SNAPSHOT"

plugins {
    java
    kotlin("jvm") version(Versions.kotlin)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

configure<KotlinProjectExtension> {
    experimental.coroutines = Coroutines.ENABLE
}

tasks {
    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
    }
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            incremental = true
            suppressWarnings = true
            apiVersion = "1.2"
            languageVersion = "1.2"
            javaParameters = true
            freeCompilerArgs = listOf("-Xdisable-default-scripting-plugin", "-Xjsr305=strict", "-Xjvm-default=enable")
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }

    withType<Wrapper> {
        gradleVersion = Versions.gradleVersion
        distributionType = Wrapper.DistributionType.ALL
        distributionUrl = "http://services.gradle.org/distributions/gradle-${Versions.gradleVersion}-all.zip"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    compile("io.arrow-kt:arrow-syntax:${Versions.arrow}")
    compile("io.arrow-kt:arrow-optics:${Versions.arrow}")
    compile("io.arrow-kt:arrow-effects:${Versions.arrow}")
    testCompile("io.kotlintest:kotlintest-runner-jvm:${Versions.kotlinTest}")
    testCompile("io.kotlintest:kotlintest-runner-junit5:${Versions.kotlinTest}")
    testCompile("io.kotlintest:kotlintest-assertions:${Versions.kotlinTest}")

    testCompile(group = "org.junit.jupiter", name =  "junit-jupiter-api", version = Versions.junit)
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = Versions.junit)
}

configurations.all {
  resolutionStrategy {
    failOnVersionConflict()
    preferProjectModules()

    force(
      "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}",
      "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}",
      "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}",
      "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}",
      "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
    )
  }
}
