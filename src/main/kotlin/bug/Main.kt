package bug

import net.bytebuddy.ByteBuddy
import net.bytebuddy.agent.ByteBuddyAgent
import org.gradle.util.GradleVersion

fun main() {
    ByteBuddyAgent.install()
    val pack = when(GradleVersion.current()) {
            GradleVersion.version("8.8") -> "org.gradle.configurationcache"
            GradleVersion.version("8.9") ->"org.gradle.internal.cc.impl"
            else -> error("only 8.8 and 8.9 are part of this reproducer")
    }
    ByteBuddy().redefine(Class.forName("$pack.DefaultConfigurationCache")).make()
    println("made redefined class")
}