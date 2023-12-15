pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidTask"
include(":app")
include(":feature:city")
include(":feature:posts")
include(":feature:postdetails")
include(":core:database")
include(":core:network")
include(":core:model")
include(":core:data")
include(":core:ui")
include(":core:common")
