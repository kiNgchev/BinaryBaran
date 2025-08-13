dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

rootProject.name = "BinaryBaran"

include("baran-shared")
include("baran-models")
include("baran-worker")