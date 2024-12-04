package emre.workspace.jetpackcomposedemo.viewmodel

import androidx.lifecycle.ViewModel
import emre.workspace.jetpackcomposedemo.data.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailViewModel : ViewModel() {

    private val _selectedMessage = MutableStateFlow<Message?>(null)
    val selectedMessage: StateFlow<Message?> = _selectedMessage

    fun setSelectedMessage(message: Message) {
        _selectedMessage.value = message
    }
}
