import com.google.gson.Gson
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class ClientServiceTest {

    private val gson = Gson()
    private val clientService = ClientService()

    @Test
    fun `success save client`() {
        val client = getClientFromJson("/success/user.json")
        val result = clientService.saveClient(client)
        assertNotNull(result)
    }

    @Test
    fun `fail save client - validation error`() {
        val client = getClientFromJson("/fail/user_with_bad_phone.json")
        assertThrows<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
    }

    @Test
    fun `fail save client - validation errors`() {
        val client = getClientFromJson("/fail/user_data_corrupted.json")
        val exception = assertFailsWith<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(exception.errorCode[0], ErrorCode.INVALID_PHONE_NUMBER)
        assertEquals(exception.errorCode[1], ErrorCode.NULL_FIELD)
        assertEquals(exception.errorCode[2], ErrorCode.INVALID_NAME)
        assertEquals(exception.errorCode[3], ErrorCode.INVALID_EMAIL)
        assertEquals(exception.errorCode[4], ErrorCode.INVALID_SNILS)
    }

    private fun getClientFromJson(fileName: String): Client = this::class.java.getResource(fileName)
        .takeIf { it != null }
        ?.let { gson.fromJson(it.readText(), Client::class.java) }
        ?: throw Exception("Что-то пошло не так))")

}