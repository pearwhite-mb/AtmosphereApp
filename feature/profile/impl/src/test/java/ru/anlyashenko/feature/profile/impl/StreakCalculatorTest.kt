package ru.anlyashenko.feature.profile.impl

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.anlyashenko.core.common.util.ProfileStatsCalculator
import java.time.LocalDate

class StreakCalculatorTest {

    @Test
    fun `when 0 entries this year, progress is 0 percent`() {
        // Arrange: Задаем "сегодня" (не високосный год, 365 дней)
        val fakeToday = LocalDate.of(2023, 12, 31)
        val dates = emptyList<LocalDate>()

        // Act: Считаем прогресс
        val result = ProfileStatsCalculator.calculateYearlyProgress(dates, fakeToday)

        // Assert: Должен быть 0%
        assertEquals(0, result)
    }

    @Test
    fun `when entries are half of the year, progress is 50 percent`() {
        // Arrange
        val fakeToday = LocalDate.of(2023, 12, 31) // Год 365 дней

        // Генерируем 182 записи (почти ровно половина от 365)
        val dates = List(182) { fakeToday }

        // Act
        val result = ProfileStatsCalculator.calculateYearlyProgress(dates, fakeToday)

        // Assert: (182 / 365) * 100 = 49.86 -> toInt() = 49
        assertEquals(49, result)
    }

    @Test
    fun `when entries are from previous year, progress is 0 percent`() {
        // Arrange
        val fakeToday = LocalDate.of(2024, 6, 1)

        // Записи были сделаны в 2023 году
        val oldDates = listOf(
            LocalDate.of(2023, 5, 1),
            LocalDate.of(2023, 5, 2)
        )

        // Act
        val result = ProfileStatsCalculator.calculateYearlyProgress(oldDates, fakeToday)

        // Assert: В текущем 2024 году записей нет
        assertEquals(0, result)
    }
}
