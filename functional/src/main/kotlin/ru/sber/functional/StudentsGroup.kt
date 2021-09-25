package ru.sber.functional

class StudentsGroup {

    private val students = listOf(
        Student(firstName = "John", lastName = "Travolta", averageRate = 4.0),
        Student(firstName = "Brad", lastName = "Pitt", averageRate = 4.1),
        Student(firstName = "Leonardo", lastName = "Dicaprio", averageRate = 4.2)
    )

    fun filterByPredicate(condition: (Student) -> Boolean): List<Student> {
        return students.filter(condition)
    }
}
