package me.mateus.aula34threadscoroutines.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.mateus.aula34threadscoroutines.R
import me.mateus.aula34threadscoroutines.repo.Repository
import me.mateus.aula34threadscoroutines.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val repo = Repository()
    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(mc: Class<T>): T {
                return MainViewModel(repo) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.activityMain_btnAtualizar).setOnClickListener {
            viewModel.getFilmesRepo()
        }

        viewModel.filmesData.observe(this, { filmes ->
            findViewById<TextView>(R.id.activityMain_tvConteudo).text = filmes.joinToString(separator = ", ")
        })
    }
}