plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.6.1")
    implementation("org.springframework:spring-context:5.3.9")

    implementation("com.squareup.okhttp:okhttp:2.7.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.5")
    implementation("com.opencsv:opencsv:5.5.2")

    annotationProcessor("info.picocli:picocli-codegen:4.6.1")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
}

application {
    mainClass.set("br.psc.guilherme.lol.data.App")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "br.psc.guilherme.lol.data.App")
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(configurations.compileClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
}
