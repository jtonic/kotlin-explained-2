val sourceSets = java.sourceSets
fun sourceSets(block: SourceSetContainer.() -> Unit) = sourceSets.apply(block)

val SourceSetContainer.main: SourceSet get() = getByName("main")
val SourceSetContainer.test: SourceSet get() = getByName("test")
fun SourceSetContainer.main(block: SourceSet.() -> Unit) = main.apply(block)
fun SourceSetContainer.test(block: SourceSet.() -> Unit) = test.apply(block)

val SourceSet.kotlin: SourceDirectorySet
    get() = (this as HasConvention).convention.getPlugin<KotlinSourceSet>().kotlin
var SourceDirectorySet.sourceDirs: Iterable<File>
    get() = srcDirs
    set(value) { setSrcDirs(value) }

sourceSets {
    main {
        java.sourceDirs = files("src")
        kotlin.sourceDirs = files("src")
    }
    test {
        java.sourceDirs = files("test")
        kotlin.sourceDirs = files("test")
    }
}

