package com.akikanellis.gradletest

import kotlin.test.Test
import kotlin.test.assertTrue

class LibraryTest {
    @Test
    fun someLibraryMethodReturnsTrue() {
        val classUnderTest = Library()
        assertTrue(true, "someLibraryMethod should return 'true'")
    }
}
