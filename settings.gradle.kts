rootProject.name = "kotlin-explained-2"

pluginManagement {

  resolutionStrategy {

    eachPlugin {

      when(requested.id.id) {
        "org.jetbrains.kotlin.jvm" ->
          useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
        "org.jetbrains.kotlin.plugin.allopen" ->
          useModule("org.jetbrains.kotlin:kotlin-allopen:${requested.version}")
        "org.jetbrains.kotlin.plugin.noarg" ->
          useModule("org.jetbrains.kotlin:kotlin-noarg:${requested.version}")
        else -> Unit
      }
    }
  }
}
