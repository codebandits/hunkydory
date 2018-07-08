import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    project.apply { from("gradle/scripts/versions.gradle.kts") }

    val kotlinVersion: String by extra

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

subprojects {
    apply { from("${rootProject.projectDir}/gradle/scripts/versions.gradle.kts") }

    val jvmTarget: String by extra

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        useJUnitPlatform()

        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            this.jvmTarget = jvmTarget
        }
    }
}

configure(setOf(project(":core:common"))) {
    apply { plugin("kotlin-platform-common") }
}

configure(setOf(project(":core:jvm"))) {
    apply { plugin("kotlin-platform-jvm") }
}
