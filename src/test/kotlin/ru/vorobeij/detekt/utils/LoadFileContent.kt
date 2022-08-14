package ru.vorobeij.detekt.utils

import io.github.detekt.test.utils.resource
import java.io.File
import org.jetbrains.kotlin.com.intellij.openapi.util.text.StringUtilRt

fun loadFileContent(resourceName: String) = StringUtilRt.convertLineSeparators(File(resource(resourceName)).readText())
