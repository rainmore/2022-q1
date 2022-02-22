rootProject.name = "teamgoal-2022-q1"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(
    "utils"
)

// settings.gradle.kts
pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}

fun scalaArtifact(artifactId: String): String {
    // The version in GWP project may not be the same as the shared version
    // val scalaBranch: String = getProperty("scala.branch").toString()
    val scalaBranch: String = extra["scala.branch"].toString()
    return "%s_%s".format(artifactId, scalaBranch)
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // Dependencies: Plugin
            version("plugin-docker", "7.2.0")
            version("plugin-spring-boot", "2.6.3")
            version("plugin-spring-dependency-management", "1.0.11.RELEASE")
            version("plugin-jarTest", "1.0.1")
            version("plugin-git", "4.1.1")

            version("plugin-scalatest", "0.31")
            version("plugin-shadow", "7.0.0")

            // Dependencies: Scala
            version("scala-library", "2.13.8")
            version("scala3-library", "3.1.1")
            version("scala-modules-java8-compat", "1.0.2")

            // Dependencies: Typesafe
            version("typesafe-config", "1.4.1")
            version("typesafe-logging", "3.9.4")

            // Dependencies: Logging
            version("slf4j", "1.7.33")
            version("logback", "1.2.10")

            // Spring
            version("spring-integration-mail", "5.5.8")

            // Dependencies: Data Storage
            version("hikaricp", "4.0.3")
            version("mysql", "8.0.28")
            version("hibernate-core", "5.6.4.Final")
            version("hibernate-validator", "6.2.0.Final")
            version("querydsl", "5.0.0")
            version("mongodb", "4.4.2")

            // Graphql
            version("graphql-spring-boot", "12.0.0")
            version("graphql-java-tools", "12.0.2")

            // Dependencies: Javax APIs
            version("javax-annotation-api", "1.3.2")
            version("javax-validation-api", "2.0.1.Final")
            version("javax-persistence-api", "2.2")

            version("javax-inject", "1")
            version("javax-servlet-api", "4.0.1")

            // Dependencies: Other
            version("bcmail-jdk15on", "1.70")
            version("passay", "1.6.1")

            version("apache-commons-lang", "3.12.0")
            version("apache-commons-email", "1.5")
            version("apache-commons-csv", "1.8")
            version("commons-codec", "1.15")
            version("commons-validator", "1.7")
            version("commons-io", "2.8.0")
            version("jetbrains-annotations", "23.0.0")

            version("webjars-locator", "0.42")

            version("jackson", "2.13.1")
            version("thymeleaf", "3.0.14.RELEASE")
            version("thymeleaf-extra", "3.0.4.RELEASE")
            version("thymeleaf-layout-dialect", "3.0.0")

            // EDI
            version("smooks", "2.0.0-M2")
            version("edi-unedifact", "1.4")

            // Testing
            version("junit-jupiter", "5.8.2")
            version("assertj-core", "3.22.0")

            version("scalactic", "3.2.11")
            version("scalatest", "3.2.11")
            version("scalatest-plus", "3.2.11.0")
            // Do not upgrade these versions unless ScalaTest is updated
            version("flexmark-scalaTest", "0.62.2")
            version("jfairy", "0.6.2")
            version("mockito", "4.2.0")

            // Plugins
            plugin("git", "org.ajoberstar.grgit").versionRef("plugin-git")
            plugin("scalatest", "com.github.maiflai.scalatest").versionRef("plugin-scalatest")
            plugin("jarTest", "com.github.hauner.jarTest").versionRef("plugin-jarTest")
            plugin("docker", "com.bmuschko.docker-spring-boot-application").versionRef("plugin-docker")
            plugin("shadow", "com.github.johnrengelman.shadow").versionRef("plugin-shadow")
            plugin("spring-boot", "org.springframework.boot").versionRef("plugin-spring-boot")
            plugin("spring-dependency-management", "io.spring.dependency-management").versionRef("plugin-spring-dependency-management")

            // Scala
            library("scala-library", "org.scala-lang", "scala-library").versionRef("scala-library")
            library("scala3-library", "org.scala-lang", scalaArtifact("scala3-library")).versionRef("scala3-library")
            library("scala-java8-compat", "org.scala-lang.modules", scalaArtifact("scala-java8-compat")).versionRef("scala-modules-java8-compat")

            library("typesafe-config", "com.typesafe", "config").versionRef("typesafe-config")
            library("typesafe-logging", "com.typesafe.scala-logging", scalaArtifact("scala-logging")).versionRef("typesafe-logging")

            // Logging
            library("slf4j-api", "org.slf4j", "slf4j-api").versionRef("slf4j")
            library("slf4j-log4j-over-slf4j", "org.slf4j", "log4j-over-slf4j").versionRef("slf4j")
            library("slf4j-nop", "org.slf4j", "slf4j-nop").versionRef("slf4j")
            library("logback-classic", "ch.qos.logback", "logback-classic").versionRef("logback")
            library("logback-core", "ch.qos.logback", "logback-core").versionRef("logback")

            // Spring
            library("spring-integration-mail", "org.springframework.integration", "spring-integration-mail").versionRef("spring-integration-mail")

            // Db
            library("mysql", "mysql", "mysql-connector-java").versionRef("mysql")
            library("hikaricp", "com.zaxxer", "HikariCP").versionRef("hikaricp")
            library("hibernate-core", "org.hibernate", "hibernate-core").versionRef("hibernate-core")
            library("hibernate-entitymanager", "org.hibernate", "hibernate-entitymanager").versionRef("hibernate-core")
            library("hibernate-java8", "org.hibernate", "hibernate-java8").versionRef("hibernate-core")
            library("hibernate-validator", "org.hibernate.validator", "hibernate-validator").versionRef("hibernate-validator")

            library("querdsl-apt", "com.querydsl", "querydsl-apt").versionRef("querydsl")
            library("querdsl-sql", "com.querydsl", "querydsl-sql").versionRef("querydsl")
            library("querdsl-jpa", "com.querydsl", "querydsl-jpa").versionRef("querydsl")
            library("querdsl-scala", "com.querydsl", "querydsl-scala").versionRef("querydsl")
            library("querdsl-mongodb", "com.querydsl", "querydsl-mongodb").versionRef("querydsl")

            // MongoDB
            library("mongodb-driver-core", "org.mongodb", "mongodb-driver-core").versionRef("mongodb")
            library("mongodb-driver-sync", "org.mongodb", "mongodb-driver-sync").versionRef("mongodb")
            library("mongodb-driver-reactivestreams", "org.mongodb", "mongodb-driver-reactivestreams").versionRef("mongodb")

            // JAVAX
            library("javax-validation-api", "javax.validation", "validation-api").versionRef("javax-validation-api")
            library("javax-persistence-api", "javax.persistence", "javax.persistence-api").versionRef("javax-persistence-api")
            library("javax-annotation-api", "javax.annotation", "javax.annotation-api").versionRef("javax-annotation-api")
            library("javax-inject", "javax.inject", "javax.inject").versionRef("javax-inject")
            library("javax-servlet-api", "javax.servlet", "javax.servlet-api").versionRef("javax-servlet-api")

            library("webjars-locator", "org.webjars", "webjars-locator").versionRef("webjars-locator")

            library("passay", "org.passay", "passay").versionRef("passay")
            library("bouncycastle", "org.bouncycastle", "bcmail-jdk15on").versionRef("bcmail-jdk15on")

            library("apache-commons-lang", "org.apache.commons", "commons-lang3").versionRef("apache-commons-lang")
            library("apache-commons-email", "org.apache.commons", "commons-email").versionRef("apache-commons-email")
            library("apache-commons-csv", "org.apache.commons", "commons-csv").versionRef("apache-commons-csv")
            library("commons-codec", "commons-codec", "commons-codec").versionRef("commons-codec")
            library("commons-validator", "commons-validator", "commons-validator").versionRef("commons-validator")
            library("commons-io", "commons-io", "commons-io").versionRef("commons-io")
            library("jetbrains-annotations", "org.jetbrains", "annotations").versionRef("jetbrains-annotations")

            // Graphql
            library("graphql-spring-boot-starter", "com.graphql-java-kickstart", "graphql-spring-boot-starter").versionRef("graphql-spring-boot")
            library("graphql-java-tools", "com.graphql-java-kickstart", "graphql-java-tools").versionRef("graphql-java-tools")

            // Thymeleaf
            library("thymeleaf", "org.thymeleaf", "thymeleaf").versionRef("thymeleaf")
            library("thymeleaf-spring5", "org.thymeleaf", "thymeleaf-spring5").versionRef("thymeleaf")
            library("thymeleaf-extras-springsecurity5", "org.thymeleaf.extras", "thymeleaf-extras-springsecurity5").versionRef("thymeleaf-extra")
            library("thymeleaf-extras-java8time", "org.thymeleaf.extras", "thymeleaf-extras-java8time").versionRef("thymeleaf-extra")
            library("thymeleaf-layout-dialect", "nz.net.ultraq.thymeleaf", "thymeleaf-layout-dialect").versionRef("thymeleaf-layout-dialect")

            // Jackson
            library("jackson-core", "com.fasterxml.jackson.core", "jackson-core").versionRef("jackson")
            library("jackson-datatype-jdk8", "com.fasterxml.jackson.datatype", "jackson-datatype-jdk8").versionRef("jackson")
            library("jackson-datatype-jsr310", "com.fasterxml.jackson.datatype", "jackson-datatype-jsr310").versionRef("jackson")
            library("jackson-datatype-hibernate5", "com.fasterxml.jackson.datatype", "jackson-datatype-hibernate5").versionRef("jackson")
            library("jackson-module-scala", "com.fasterxml.jackson.module", scalaArtifact("jackson-module-scala")).versionRef("jackson")

            // EDI
            library("smooks-edi-cartridge", "org.smooks.cartridges.edi", "smooks-edi-cartridge").versionRef("smooks")
            library("smooks-javabean-cartridge", "org.smooks.cartridges", "smooks-javabean-cartridge").versionRef("smooks")
            library("edi-unedifact-d99b-mapping", "org.milyn.edi.unedifact", "d99b-mapping").versionRef("edi-unedifact")
            library("edi-unedifact-d99b-binding", "org.milyn.edi.unedifact", "d99b-binding").versionRef("edi-unedifact")

            // Test
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef("junit-jupiter")
            library("junit-jupiter-api", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit-jupiter")
            library("junit-jupiter-params", "org.junit.jupiter", "junit-jupiter-params").versionRef("junit-jupiter")
            library("assertj-core", "org.assertj", "assertj-core").versionRef("assertj-core")

            library("scalactic", "org.scalactic", scalaArtifact("scalactic")).versionRef("scalactic")
            library("scalatest", "org.scalatest", scalaArtifact("scalatest")).versionRef("scalatest")
            library("scalatest-plus-mockito", "org.scalatestplus", scalaArtifact("mockito-3-12")).versionRef("scalatest-plus")
            library("scalatest-plus-mockito-4-2", "org.scalatestplus", scalaArtifact("mockito-4-2")).versionRef("scalatest-plus")
            library("flexmark-all-scalaTest", "com.vladsch.flexmark", "flexmark-all").versionRef("flexmark-scalaTest")
            library("jfairy", "com.devskiller", "jfairy").versionRef("jfairy")

            library("commons-lang3", "org.apache.commons", "commons-lang3").version {
                strictly("[3.8, 4.0[")
                prefer("3.9")
            }


            // Bundles
            bundle("scala2", listOf("scala-library", "scala-java8-compat"))
            bundle("scala", listOf("scala3-library", "scala-java8-compat"))
            bundle("logging", listOf("slf4j-api", "slf4j-log4j-over-slf4j", "logback-classic", "logback-core", "typesafe-logging"))
            bundle("logging-java", listOf("slf4j-api", "slf4j-log4j-over-slf4j", "logback-classic", "logback-core"))
            bundle("hibernate", listOf("hibernate-core", "hibernate-entitymanager", "hibernate-java8", "hibernate-validator", "javax-validation-api"))
            bundle("mongodb", listOf("mongodb-driver-core", "mongodb-driver-sync", "mongodb-driver-reactivestreams"))
            bundle("thymeleaf", listOf("thymeleaf", "thymeleaf-spring5", "thymeleaf-extras-springsecurity5", "thymeleaf-extras-java8time", "thymeleaf-layout-dialect"))
            bundle("jackson", listOf("jackson-core", "jackson-datatype-jdk8", "jackson-datatype-jsr310", "jackson-datatype-hibernate5", "jackson-module-scala"))
            bundle("jackson-mongodb", listOf("jackson-core", "jackson-datatype-jdk8", "jackson-datatype-jsr310"))
            bundle("graphql", listOf("graphql-spring-boot-starter", "graphql-java-tools"))

            bundle("scalatest", listOf("scalactic", "scalatest", "scalatest-plus-mockito-4-2", "typesafe-logging"))
            bundle("junit-jupiter", listOf("junit-jupiter", "junit-jupiter-api", "junit-jupiter-params", "assertj-core"))
        }
    }
}
