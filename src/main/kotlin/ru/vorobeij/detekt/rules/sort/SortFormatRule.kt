package ru.vorobeij.detekt.rules.sort

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class SortFormatRule : Rule("SortRule") {

    private val sorter = Sorter()

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {

        println("sorting rule debug... autoCorrect = $autoCorrect")
        if (node.elementType == KtStubElementTypes.CLASS_BODY) {
            val children: Array<ASTNode> = node.getChildren(null)
            val innerElements: List<ASTNode> = children.filteredInnerElements()
            val sortedInnerElements: List<ASTNode> = innerElements.sort()

            if (innerElements != sortedInnerElements) {

                emit(node.startOffset, "Incorrect order of inners", true)

                if (autoCorrect) {
                    autocorrect(node, innerElements, sortedInnerElements)
                }
            }
        }
    }

    private fun Array<ASTNode>.filteredInnerElements() = filter { sorter.sortList.contains(it.elementType) }

    private fun List<ASTNode>.sort(): List<ASTNode> {
        return sortedBy { sorter.getMethodIndex(it) }
            .sortedBy { sorter.getModifierIndex(it) }
            .sortedBy { sorter.sortList.indexOf(it.elementType) }
    }

    private fun autocorrect(
        node: ASTNode,
        innerElements: List<ASTNode>,
        sortedInnerElements: List<ASTNode>
    ) {
        innerElements.forEach {
            node.removeChild(it)
        }

        val start: ASTNode = node.findChildByType(KtTokens.LBRACE)!!.treeNext

        sortedInnerElements.forEach { astNode ->
            node.addChild(astNode, start)
            val nesting = sorter.nestingLevel(astNode)
            node.removeChild(astNode)
            node.addChild(PsiWhiteSpaceImpl("\n\n" + sorter.indentation(nesting)), start)
            node.addChild(astNode, start)
        }
        sorter.removeWhitespacesBefore(
            node,
            node.findChildByType(KtTokens.RBRACE)!!
        )
    }
}
