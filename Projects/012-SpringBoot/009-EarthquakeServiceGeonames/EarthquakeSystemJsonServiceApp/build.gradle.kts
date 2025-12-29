plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.edaakyil"
version = "1.0.0"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.postgresql:postgresql:42.7.3")

	compileOnly("org.projectlombok:lombok:1.18.34")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("com.edaakyil:EarthquakeSystemGeonamesServiceLib:1.0.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
