package me.mateus.aula34threadscoroutines.repo

import kotlinx.coroutines.delay
import java.util.*

class Repository {

    suspend fun getFilmes(): Array<String> {
        delay(3000)
        return mutableListOf<String>().apply {
            val r = Random()
            val letras = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
            (0..r.nextInt(100)).forEach {
                add(letras.run {
                    var palavra = ""
                    (0..r.nextInt(8)).forEach {
                        palavra += random()
                    }
                    palavra
                })
            }
            letras.random()
        }.toTypedArray()
    }
}