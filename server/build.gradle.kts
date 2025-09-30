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

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

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

tasks.withType<Test> {
	useJUnitPlatform()
}





