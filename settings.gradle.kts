pluginManagement {
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
        jcenter()
        maven { url=uri("https://jitpack.io") }
        maven { url = uri("https://s01.oss.sonatype.org/content/groups/public") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
    }
}

rootProject.name = "Lzp102"
include(":app")
 