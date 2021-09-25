package ru.sber.datetime

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.*

// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {

    return ZoneId.getAvailableZoneIds().filter { TimeZone.getTimeZone(it).rawOffset % 3_600_000 != 0 }.toSet()

}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {

    return Month.values().map {
        LocalDate
        .of(year, it, 1)
        .with(TemporalAdjusters.lastDayOfMonth())
        .dayOfWeek
        .name
    }.toList()
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {

    return Month.values().map {
        LocalDate
            .of(year, it, 13)
            .dayOfWeek
            .name
    }.filter{
        it == "FRIDAY"
    }.size
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {

    return DateTimeFormatter.ofPattern("dd MMM uuuu, HH:mm").withLocale(Locale.US).format(dateTime)

}



