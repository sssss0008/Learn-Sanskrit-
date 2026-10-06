package com.example

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun sanskritRepository_datasetsLoaded() {
    val swaras = com.example.data.repository.SanskritRepository.swaras
    val vyanjanas = com.example.data.repository.SanskritRepository.vyanjanas
    val shabdaRupa = com.example.data.repository.SanskritRepository.shabdaRupaTables
    val dhatuRupa = com.example.data.repository.SanskritRepository.dhatuRupaTables
    val cultureArticles = com.example.data.repository.SanskritRepository.cultureArticles

    assertTrue("Swaras should not be empty", swaras.isNotEmpty())
    assertTrue("Vyanjanas should not be empty", vyanjanas.isNotEmpty())
    assertTrue("Shabda Rupa tables should not be empty", shabdaRupa.isNotEmpty())
    assertTrue("Dhatu Rupa tables should not be empty", dhatuRupa.isNotEmpty())
    assertTrue("Culture articles should be present", cultureArticles.size >= 4)
  }
}
