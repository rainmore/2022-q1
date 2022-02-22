import java.nio.file.Path

plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)

    java
    idea
    application
    checkstyle
    pmd
}

group = "com.worldmanager"
version = "1.0.0"
description = "Demo Project for 2022 Q1 Team Goal"

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = project.properties["gradleVersion"] as String
}

application {
    mainClass.set(listOf(project.group.toString(), "Application").joinToString("."))
}


configurations.all {
    exclude("org.apache.logging.log4j:*")
}


dependencies {
//    implementation(project(":utils"))
    implementation(projects.utils)


    annotationProcessor(libs.javax.persistence.api)
    annotationProcessor(libs.javax.annotation.api)

    implementation(libs.javax.inject)

    // query dsl
    implementation(libs.querdsl.jpa)
    implementation(libs.querdsl.mongodb)
    implementation(libs.jetbrains.annotations)

    // spring
    implementation("org.springframework.data:spring-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-tomcat")

    // Jackson
    implementation(libs.bundles.mongodb)
    implementation(libs.bundles.jackson.mongodb)

    implementation(libs.bundles.logging.java)

    implementation(libs.bundles.graphql)

    testImplementation(libs.bundles.junit.jupiter)
    testImplementation(libs.jfairy)
}


tasks.register("bar") {
    group = "Demo"
    dependsOn(":utils:foo")
    doLast {
        println("bar task is triggered")
        println("utils project's name: " + projects.utils.name)
        println("utils project's group: " + projects.utils.group)
        println("utils project's version: " + projects.utils.version)
    }
}
