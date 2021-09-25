class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    NULL_FIELD(100, "Пустое поле"),
    INVALID_PHONE_NUMBER(100, "Неверный формат телефонного номера, должен содержать 11 цифр начиная с 7 или 8"),
    INVALID_NAME(100, "Неверный формат Имени и\\или Фамилии, допустима только кирилица максимальная длина 16 символов"),
    INVALID_EMAIL(100, "Неверный формат электронной почты, допустима только латиница, максимальная длина 32 символ и @имя_домена на конце"),
    INVALID_SNILS(100, "Неверный формат СНИЛСа, должен состоять из 11 цифр, либо не совпадает контрольное число")

    // ...
}