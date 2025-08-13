plugins {
    id("common-conventions")
    id("spring-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":baran-shared"))
}