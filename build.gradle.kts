import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.6.21"
}

group = "net.deechael"
version = "1.00.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2")
    implementation("com.squareup.okhttp3:okhttp:4.10.0") // WebSocket
    implementation("com.google.code.gson:gson:2.9.0") // Json
    implementation("ch.qos.logback:logback-classic:1.2.11") // Logging
    implementation("org.yaml:snakeyaml:1.30") // Configuration
    implementation("commons-lang:commons-lang:2.6") // Utils
    implementation("com.google.guava:guava:31.1-jre") // Utils
    implementation("net.deechael:Useless:1.02.0") // Utils

    //Lombok
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    testCompileOnly("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.withType<Test> {
    defaultCharacterEncoding = "UTF-8"
}
tasks.withType<Javadoc>{
    options.encoding = "UTF-8"
}