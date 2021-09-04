package tech.futuretecnologia.gestorfinanceiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.futuretecnologia.gestorfinanceiro.R
import kotlinx.android.synthetic.main.activity_operacoes.*

class   OperacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacoes)
        navigation_op_adc.setupWithNavController(findNavController(R.id.fragment_operacoes_mensais))
    }

    var tmp = 0

    override fun onBackPressed() {
        /*
        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var restante = millisUntilFinished
                Toast.makeText(applicationContext, "Deslogando em " + restante/1000 + " segundos", Toast.LENGTH_LONG).show()

            }
            override fun onFinish() {
                finishAffinity()
            }
        }
        if (tmp == 0){
            timer.start()
            tmp++
        }
    }
         */
        finish()
    }
}
