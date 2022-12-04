package com.akikanellis.gradletest

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class LibraryTest {
    @Test
    fun someLibraryMethodReturnsTrue() {
        val classUnderTest = Library()
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'")
    }
}
