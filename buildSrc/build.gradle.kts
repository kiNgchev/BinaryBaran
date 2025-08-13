plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(plugin(libs.plugins.kotlin.jvm))
    implementation(plugin(libs.plugins.kotlin.serialization))
    implementation(plugin(libs.plugins.kotlin.spring))
    implementation(plugin(libs.plugins.kotlin.jpa))
    implementation(plugin(libs.plugins.dependency.managment))
    implementation(plugin(libs.plugins.spring.boot))
    implementation(plugin(libs.plugins.kapt))
    implementation(plugin(libs.plugins.ksp))
    implementation(plugin(libs.plugins.ktgram))
}

fun DependencyHandlerScope.plugin(plugin: Provider<PluginDependency>) =
    plugin.map { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" }