package com.example.workoutkotlinapp.src.utils.Date

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import java.util.Date

object DateUtil {
    fun showDatePicker(
        context: Context,
        onDateSet: (date: Date) -> Unit,
    ) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

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
                    onDateSet(selectedDate)
                },
                year,
                month,
                day,
            )

        datePickerDialog.show()
    }
}
