package ru.anlyashenko.core.common.util

import java.time.LocalDate

object ProfileStatsCalculator {

    fun calculateStreaks(
        datesDescending: List<LocalDate>,
        today: LocalDate = LocalDate.now()
    ): Pair<Int, Int> {
        if (datesDescending.isEmpty()) return Pair(0, 0)

        var currentStreak = 0
        var longestStreak = 0
        var tempStreak = 1

        val yesterday = today.minusDays(1)
        var isActiveStreak = datesDescending.first() == today || datesDescending.first() == yesterday

        if (isActiveStreak) currentStreak = 1

        for (i in 0 until datesDescending.size - 1) {
            val current = datesDescending[i]
            val next = datesDescending[i + 1]

            if (current.minusDays(1) == next) {
                tempStreak++
                if (isActiveStreak) currentStreak = tempStreak
            } else if (current != next) {
                if (tempStreak > longestStreak) longestStreak = tempStreak
                tempStreak = 1
                isActiveStreak = false
            }
        }
        if (tempStreak > longestStreak) longestStreak = tempStreak

        return Pair(currentStreak, longestStreak)
    }

    fun calculateYearlyProgress(
        recordsDates: List<LocalDate>,
        today: LocalDate = LocalDate.now()
    ): Int {
        val currentYear = today.year
        val entriesThisYear = recordsDates.count { it.year == currentYear }
        val daysInYear = if (today.isLeapYear) 366 else 365
        return ((entriesThisYear.toFloat() / daysInYear) * 100).toInt()
    }
}
