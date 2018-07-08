dependencies {
    val junitVersion: String by extra

    expectedBy(project(":core:common"))

    compile("org.jetbrains.kotlin:kotlin-stdlib")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit5")
    testCompile("org.jetbrains.kotlin:kotlin-test")

    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}
