plugins {
    kotlin("jvm") version "2.4.20"
    application
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

sourceSets.main.get().kotlin.srcDirs(
    "src/main/kotlin",
    "../../../utilities/collections/kotlin/src/main/kotlin",
    "../../../utilities/strings/kotlin/src/main/kotlin",
    "../../../utilities/numbers/kotlin/src/main/kotlin",
    "../../../utilities/dates/kotlin/src/main/kotlin",
    "../../../utilities/validation/kotlin/src/main/kotlin"
)

application {
    mainClass.set("MatrixTestKt")
}
