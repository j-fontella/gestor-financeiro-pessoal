package tech.futuretecnologia.gestorfinanceiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.futuretecnologia.gestorfinanceiro.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_navegador.setupWithNavController(findNavController(R.id.fragment_conta_menu))

    }
}
