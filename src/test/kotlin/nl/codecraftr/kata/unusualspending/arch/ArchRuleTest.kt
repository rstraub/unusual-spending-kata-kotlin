package nl.codecraftr.kata.unusualspending.arch

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(packages = arrayOf("nl.codecraftr.kata.unusualspending"))
class ArchRuleTest {
    @ArchTest
    fun rule_as_method(importedClasses: JavaClasses) {
        val rule = ArchRuleDefinition.classes().should().accessClassesThat()
                .arePublic()
        rule.check(importedClasses)
    }
}
