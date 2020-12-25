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
    testCompile("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    testRuntime("org.junit.platform:junit-platform-console:1.2.0")
    implementation("org.mockito:mockito-core:2.+")
    implementation("org.json:json:20200518")
}

tasks {
    val flags =
            listOf("-Xlint:unchecked", "-Xlint:deprecation", "--enable-preview", "-Xlint:preview")

    getByName<JavaCompile>("compileJava") {
        options.compilerArgs = flags
    }

    getByName<JavaCompile>("compileTestJava") {
        options.compilerArgs = flags
    }
    getByName<JavaExec>("run"){
        jvmArgs("--enable-preview")
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
    jvmArgs("--enable-preview")
}

pmd {
    ruleSets = listOf()
    ruleSetFiles = files("../conf/pmd/ruleset.xml")
    toolVersion = "6.27.0"
}

application {
   mainClassName = "locator.ui.IssInformationApp"
}

tasks.withType<JacocoReport> {
    afterEvaluate {
        classDirectories.setFrom(files(classDirectories.files.map {
            fileTree(it).apply {
                exclude("**/preview/**")
                exclude("**/ui/**")
            }
        }))
    }
}

defaultTasks("clean", "test", "jacocoTestReport", "pmdMain")