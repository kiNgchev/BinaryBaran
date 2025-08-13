plugins {
    id("common-conventions")
    id("spring-conventions")
}

tasks.bootJar {
    enabled = false
}