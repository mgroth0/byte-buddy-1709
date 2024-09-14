

plugins {
    val ktVersion= "2.0.20"
    kotlin("jvm") version ktVersion
    application
}

application {
    mainClass.set("bug.MainKt")
}

repositories {
    mavenCentral()
}
dependencies {
    implementation(gradleApi())
    val byteBuddyVersion = "1.15.1"
    implementation("net.bytebuddy:byte-buddy:$byteBuddyVersion")
    implementation("net.bytebuddy:byte-buddy-agent:$byteBuddyVersion")
}