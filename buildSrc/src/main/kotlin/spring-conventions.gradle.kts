plugins {
    id("common-conventions")
    io.spring.`dependency-management`
    org.springframework.boot
    org.jetbrains.kotlin.plugin.spring
    org.jetbrains.kotlin.plugin.jpa
}

repositories {
    mavenCentral()
}

val libs = the<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(libs.findBundle("spring-implementation").get())
    // CompileOnly dependencies
    compileOnly(libs.findBundle("spring-compile-only").get())
    // DevelopmentOnly dependencies
    developmentOnly(libs.findBundle("spring-development-only").get())
    // RuntimeOnly dependencies
    runtimeOnly(libs.findBundle("spring-runtime-only").get())
    // AnnotationProcessor dependencies
    annotationProcessor(libs.findBundle("spring-annotation-processor").get())
    kapt(libs.findLibrary("spring-boot-configuration-processor").get())
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${libs.findVersion("spring-cloud").get()}")
    }
}
