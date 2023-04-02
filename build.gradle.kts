plugins {
    id("java")
    id("io.freefair.lombok") version "6.6.2"
}

group = "cc.ddev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.6")
}