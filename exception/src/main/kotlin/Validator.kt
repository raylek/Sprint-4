abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val regex = "[аА-яЯ]{1,16}".toRegex()

        if(value == null) {
            return listOf(ErrorCode.NULL_FIELD)
        }

        if(!regex.matches(value)) {
            return listOf(ErrorCode.INVALID_NAME)
        }

        return listOf()
    }
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val regex = "[78](\\d{10})".toRegex()

        if(value == null) {
            return listOf(ErrorCode.NULL_FIELD)
        }

        if(!regex.matches(value)) {
            return listOf(ErrorCode.INVALID_PHONE_NUMBER)
        }

        return listOf()
    }
}

class EmailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val regex = "\\w+@\\w+\\.\\w+".toRegex()
        val lenRegex = ".{1,32}".toRegex()

        if(value == null) {
            return listOf(ErrorCode.NULL_FIELD)
        }

        if(!regex.matches(value) || !lenRegex.matches(value)) {
            return listOf(ErrorCode.INVALID_EMAIL)
        }

        return listOf()
    }
}

class SNILSValidation : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val regex = "\\d{11}".toRegex()

        if(value == null) {
            return listOf(ErrorCode.NULL_FIELD)
        }

        if(!regex.matches(value)) {
            return listOf(ErrorCode.INVALID_SNILS)
        }

        if(!isControlSumIsValid(value)) {
            return listOf(ErrorCode.INVALID_SNILS)
        }

        return listOf()
    }

    private fun isControlSumIsValid(number: String): Boolean {

        var sum = 0
        var controlNumber: Int

        for (i in 0 until 9) {
            sum += Character.getNumericValue(number[i]) * (9 - i)
        }

        if (sum == 100 || sum == 101) {
            controlNumber = 0
        } else if (sum < 100) {
            controlNumber = sum
        } else {
            controlNumber = sum % 101
        }

        return number.substring(9).toInt() == controlNumber
    }
}