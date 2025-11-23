plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.edaakyil"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}
/*
java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}*/

repositories {
	mavenCentral()
	mavenLocal()
	maven {
		url = uri("https://raw.github.com/oguzkaran/javaapp1-nov-2023-maven-repo/main")
	}
	maven {
		url = uri("https://raw.github.com/oguzkaran/javaapp1-nov-2023-karandev-maven-repo/main")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.karandev:com-karandev-util-console:11.2.0")
    implementation("org.csystem:org-csystem-util:12.0.0")
    implementation("org.csystem:org-csystem-scheduler:14.0.1")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
