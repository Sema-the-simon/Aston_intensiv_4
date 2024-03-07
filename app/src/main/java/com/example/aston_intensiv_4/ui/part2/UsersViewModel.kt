package com.example.aston_intensiv_4.ui.part2

import androidx.lifecycle.ViewModel
import com.example.aston_intensiv_4.model.User
import com.example.aston_intensiv_4.utils.getUsers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UsersViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    fun changeUser(user: User) {
        val updatedList = uiState.value.usersList.toMutableList()
        val userIndex = updatedList.indexOfFirst {
            it.id == user.id
        }
        updatedList.removeAt(userIndex)
        updatedList.add(userIndex, user)
        _uiState.update {
            it.copy(
                usersList = updatedList
            )
        }
    }
}

data class MainUiState(
    val usersList: List<User> = getUsers(),
)
