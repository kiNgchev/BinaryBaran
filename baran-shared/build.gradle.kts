plugins {
    id("common-conventions")
    id("spring-conventions")
}

dependencies {
    api(libs.bundles.spring.implementation)
    api(project(":baran-models"))
}

tasks.bootJar {
    enabled = false
}