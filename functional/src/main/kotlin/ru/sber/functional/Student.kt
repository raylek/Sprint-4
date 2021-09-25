package ru.sber.functional

data class Student(
    val firstName: String,
    val lastName: String,
    val middleName: String = "Not applicable",
    val age: Int = 18,
    val averageRate: Double,
    val city: String = "Not applicable",
    val specialization: String = "Not applicable",
    val prevEducation: String? = "Not applicable",
)
