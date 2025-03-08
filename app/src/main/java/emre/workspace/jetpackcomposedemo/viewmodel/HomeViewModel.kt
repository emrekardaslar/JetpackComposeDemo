package emre.workspace.jetpackcomposedemo.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import emre.workspace.jetpackcomposedemo.data.model.Message
import emre.workspace.jetpackcomposedemo.data.repository.MessageRepository
import emre.workspace.jetpackcomposedemo.managers.RemoteConfigManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val remoteConfigManager: RemoteConfigManager = RemoteConfigManager() // Inject this if needed
) : ViewModel() {

    private val repository = MessageRepository()

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    val backgroundColor = mutableStateOf("#FFFFFF") // Default background color

    init {
        fetchMessages()
        fetchBackgroundColor()
    }

    private fun fetchMessages() {
        viewModelScope.launch {
            val fetchedMessages = repository.getMessages()
            _messages.value = fetchedMessages
        }
    }

    private fun fetchBackgroundColor() {
        viewModelScope.launch {
            backgroundColor.value = remoteConfigManager.getString("background_color") ?: "#FFFFFF"
        }
    }
}


