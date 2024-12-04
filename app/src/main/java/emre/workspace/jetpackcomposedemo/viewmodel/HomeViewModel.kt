package emre.workspace.jetpackcomposedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import emre.workspace.jetpackcomposedemo.data.model.Message
import emre.workspace.jetpackcomposedemo.data.repository.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = MessageRepository() // Initialize directly for simplicity

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    init {
        fetchMessages()
    }

    private fun fetchMessages() {
        viewModelScope.launch {
            val fetchedMessages = repository.getMessages()
            _messages.value = fetchedMessages
        }
    }
}
