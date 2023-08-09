plugins {
    id("java")
    id("maven-publish")
}

group = "b100"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "b100"
            artifactId = "ASMLoader-agent"
            version = "1.0"

            from(components["java"])
        }
    }
}

tasks.withType<Jar> {
    manifest {
        attributes["Premain-Class"] = "b100.Agent"
        attributes["Agent-Class"] = "b100.Agent"
        attributes["Can-Retransform-Classes"] = true
    }
}

tasks.test {
    useJUnitPlatform()
}