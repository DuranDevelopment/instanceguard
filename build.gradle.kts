import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    `maven-publish`
    id("com.github.johnrengelman.shadow") version ("7.1.0")
    id("io.freefair.lombok") version "6.6.2"
}

group = "cc.ddev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.6")
    implementation("com.github.Minestom:Minestom:954e8b3915")
    compileOnly("junit:junit:4.13.2")
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("instanceguard")
        archiveFileName.set("instanceguard-${project.version}.jar")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "cc.ddev.feather.Server", "Multi-Release" to "true"))
        }

        fun reloc(pkg: String) = relocate(pkg, "cc.ddev.shaded.$pkg")
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/durandevelopment/instanceguard")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}