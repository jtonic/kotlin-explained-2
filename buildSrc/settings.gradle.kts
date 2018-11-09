pluginManagement {

  resolutionStrategy {
    eachPlugin {

      when (requested.id.id) {
        "org.gradle.kotlin.kotlin-dsl" ->
          useModule("gradle.plugin.org.gradle.kotlin:gradle-kotlin-dsl-plugins:${requested.version}")
        else -> Unit
      }
    }
  }
}
