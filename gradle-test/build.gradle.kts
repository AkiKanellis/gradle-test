plugins {
    kotlin("jvm") version "1.7.22"
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
