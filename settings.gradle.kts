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
    }
}

rootProject.name = "Demonstrations"
include(":app")
include(":mod2demo1variable")
include(":mod2demo2conditions")
include(":mod2classe")
include(":mod2heritage")
include(":mod2interface")
include(":mod3compose")
include(":mod3lazycolumn")
include(":mod4compteur")
include(":mod4formulaire")
include(":mod4viewmodel")
include(":mod4compteur_vendredi")
include(":mod4formulaire_vendredi")
include(":mod4viewmodel_vendredi")
include(":mod4factory")
include(":mod5intentimplicite")
