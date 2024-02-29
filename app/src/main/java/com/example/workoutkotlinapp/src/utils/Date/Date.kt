package com.example.workoutkotlinapp.src.utils.Date

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.Date

object DateUtil {
    fun showDatePickerDialog(
        context: Context,
        onSetDate: (date: Date) -> Unit,
    ) {
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val month = Calendar.getInstance().get(Calendar.MONTH)
        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        val datePickerDialog =
            DatePickerDialog(
                context,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDateCalendar =
                        Calendar.getInstance().apply {
                            set(Calendar.YEAR, selectedYear)
                            set(Calendar.MONTH, selectedMonth)
                            set(Calendar.DAY_OF_MONTH, selectedDay)
                        }
                    val selectedDate = selectedDateCalendar.time
                    onSetDate(selectedDate)
                },
                year,
                month,
                day,
            )

        datePickerDialog.show()
    }

    fun parseToLocalDate(date: String): LocalDate {
        return ZonedDateTime.parse(date).toLocalDate()
    }
}
