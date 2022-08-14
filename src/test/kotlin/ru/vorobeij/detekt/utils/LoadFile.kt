package ru.vorobeij.detekt.utils

import io.github.detekt.test.utils.compileForTest
import io.github.detekt.test.utils.resource
import java.nio.file.Paths
import org.jetbrains.kotlin.psi.KtFile

fun loadFile(resourceName: String): KtFile = compileForTest(Paths.get(resource(resourceName)))
