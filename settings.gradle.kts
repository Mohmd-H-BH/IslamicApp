pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Quran"
include(":app")

//CORE
include(
    ":core:common",
    ":core:domain",
    ":core:designsystem",
    ":core:ui",
    ":core:data",
)

//Feature
include(":feature:quran")
include(":feature:onthisday")
include(":feature:prayer")
include(":feature:athkar")
include(":feature:bookmark")
include(":feature:onBoarding")

