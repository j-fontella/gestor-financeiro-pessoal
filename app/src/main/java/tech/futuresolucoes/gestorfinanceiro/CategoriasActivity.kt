package tech.futuretecnologia.gestorfinanceiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.futuretecnologia.gestorfinanceiro.R
import kotlinx.android.synthetic.main.activity_categorias.*

class CategoriasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)
        categorias_menu.setupWithNavController(findNavController(R.id.fragmentCategorias))
    }
}
