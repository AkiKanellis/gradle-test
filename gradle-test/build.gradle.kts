plugins {
    kotlin("jvm") version "1.7.21"
}

group = "com.akikanellis.gradletest"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
}

tasks.test {
    useJUnitPlatform()
}
