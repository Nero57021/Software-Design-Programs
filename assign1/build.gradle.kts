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
//        args("(5,1),(5,2),(6,1),(6,2),(5,11),(6,11),(7,11),(4,12),(3,13),(3,14),(8,12),(9,13),(9,14),(6,15),(4,16),(5,17),(6,17),(7,17),(6,18),(8,16),(3,21),(4,21),(5,21),(3,22),(4,22),(5,22),(2,23),(6,23),(1,25),(2,25),(6,25),(7,25),(3,35),(4,35),(3,36),(4,36),(40,50)")
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
 
tasks.withType<JacocoReport> {
  afterEvaluate {
    classDirectories.setFrom(files(classDirectories.files.map {
      fileTree(it).apply {
        exclude("*/preview/*")
        exclude("*/ui/*")
      }
    }))
  }
}

application {
    mainClassName = "game.ui.GameOfLifeGUI"
}

defaultTasks("clean", "test", "jacocoTestReport", "pmdMain")