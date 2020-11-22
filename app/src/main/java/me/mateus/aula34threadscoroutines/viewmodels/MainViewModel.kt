package me.mateus.aula34threadscoroutines.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.mateus.aula34threadscoroutines.repo.Repository
import java.lang.Exception

class MainViewModel(private val repo: Repository) : ViewModel() {

    val filmesData = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }


    fun getFilmesRepo() {
        viewModelScope.launch {
            try {
                filmesData.value?.apply {
                    clear()
                    addAll(repo.getFilmes())
                }
                filmesData.notifyObserver()
            } catch (ex: Exception) {
                Log.e("MainViewModel", "Erro ao acessar a lista de filmes!", ex)
            }
        }
    }

}


fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}