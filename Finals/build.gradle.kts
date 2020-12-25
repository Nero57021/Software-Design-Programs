plugins {
    java
    jacoco
    pmd
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    testRuntimeOnly("org.junit.platform:junit-platform-console:1.2.0")
    implementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
    testImplementation("org.mockito:mockito-core:3.5.13")
    implementation("org.json", "json", "20200518")

}

tasks {
    val flags =
            listOf("-Xlint:unchecked", "-Xlint:deprecation")

    getByName<JavaCompile>("compileJava") {
        options.compilerArgs = flags
    }

    getByName<JavaCompile>("compileTestJava") {
        options.compilerArgs = flags
    }
    getByName<JavaExec>("run"){
        standardInput = System.`in`
    }
}

sourceSets {
    main {
        java.srcDirs("src")
    }
    test {
        java.srcDirs("test")
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform {}
}

application {
   mainClassName = "UI.NumberCheckUI"
}
tasks.withType<JacocoReport> {
    afterEvaluate {
        classDirectories.setFrom(files(classDirectories.files.map {
            fileTree(it).apply {
                exclude("**/UI/**")
            }
        }))
    }
}

pmd {
    ruleSets = listOf()
    ruleSetFiles = files("./pmd/ruleset.xml")
    toolVersion = "6.27.0"
}


defaultTasks("clean", "test", "jacocoTestReport", "pmdMain")
