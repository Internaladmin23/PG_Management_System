plugins {
	java
    checkstyle
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("jvm") version "1.9.10" apply false // If using Kotlin
  	id("com.diffplug.spotless") version "6.16.0"
	id("org.openapi.generator") version "7.16.0" // generate TS clients if desired
	id("jacoco")
	id("com.github.spotbugs") version "5.0.13"

}

group = "com.pg-management"
version = "0.0.1-SNAPSHOT"
description = "PG management application"


repositories {
	mavenCentral()
}

spotless{
	java{
		googleJavaFormat()
	}
}

jacoco {
  toolVersion = "0.8.10"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

checkstyle {
    toolVersion = "10.12.3"
    config = resources.text.fromFile("${rootDir}/config/checkstyle/checkstyle.xml")
}


tasks.withType<Test> {
    // Skip tests if there are no compiled test classes
    onlyIf {
        val javaTestClasses = fileTree("${buildDir}/classes/java/test") {
            include("**/*.class")
        }
        val kotlinTestClasses = fileTree("${buildDir}/classes/kotlin/test") {
            include("**/*.class")
        }
        !javaTestClasses.isEmpty || !kotlinTestClasses.isEmpty
    }

    useJUnitPlatform() // Ensure JUnit 5 is used
}







