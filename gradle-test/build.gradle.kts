plugins {
    kotlin("jvm") version "1.7.22"

    jacoco
}

group = "com.akikanellis.gradletest"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
}

kotlin {
    jvmToolchain {
        val javaVendorWithVersion = File(".tool-versions").readLines()
            .single { it.contains("java") }
            .split(" ")[1]
            .split("-")
        val javaVendor = javaVendorWithVersion[0]
        val javaVersion = javaVendorWithVersion[1]
        val javaMajorVersion = javaVersion.split(".").first()

        vendor.set(
            JvmVendorSpec.matching(
                when (javaVendor) {
                    "temurin" -> "adoptium"
                    else -> javaVendor
                }
            )
        )
        languageVersion.set(JavaLanguageVersion.of(javaMajorVersion))
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
        html.required.set(false)
    }
}

tasks.register("publish") {
    group = "publish"
    description =
        """
        Dummy task to pass the verification phase of the gradle-semantic-release-plugin.
        See: https://github.com/KengoTODA/gradle-semantic-release-plugin/issues/435
        """.trimIndent()
}
