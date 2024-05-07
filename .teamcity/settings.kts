import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.project
import jetbrains.buildServer.configs.kotlin.version
import org.yaml.snakeyaml.LoaderOptions
import org.yaml.snakeyaml.Yaml

version = "2024.03"
project {
    val config = """
        data: 22
    """.trimIndent()
    val loaderOptions = LoaderOptions()
    val yaml = Yaml(loaderOptions)
    val obj = yaml.load<Any>(config)
    buildType {
        name = "Dummy"
        id("dummy")
        steps {
            script {
                scriptContent = """
                    echo "$obj"
                """.trimIndent()
            }
        }
    }
}
