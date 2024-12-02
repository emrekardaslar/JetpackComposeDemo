package emre.workspace.jetpackcomposedemo.data.repository

import emre.workspace.jetpackcomposedemo.data.model.Message

class MessageRepository {

    // Simulated data source
    private val sampleMessages = listOf(
        Message(author = "Alice", body = "Hello, how are you?"),
        Message(author = "Bob", body = "Jetpack Compose is great!"),
        Message(author = "Charlie", body = "Are you attending the meetup?")
    )

    fun getMessages(): List<Message> {
        return sampleMessages
    }
}
