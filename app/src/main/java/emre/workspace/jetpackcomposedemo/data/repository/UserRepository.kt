package emre.workspace.jetpackcomposedemo.data.repository

import emre.workspace.jetpackcomposedemo.data.model.User

class UserRepository {

    // Simulated user data
    private val sampleUsers = listOf(
        User(id = 1, name = "Alice", profilePictureRes = 1),
        User(id = 2, name = "Bob", profilePictureRes = 2),
        User(id = 3, name = "Charlie", profilePictureRes = 3)
    )

    fun getUserById(userId: Int): User? {
        return sampleUsers.find { it.id == userId }
    }
}
