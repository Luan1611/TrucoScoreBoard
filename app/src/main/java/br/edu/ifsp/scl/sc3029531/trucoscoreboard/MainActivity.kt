package br.edu.ifsp.scl.sc3029531.trucoscoreboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.sc3029531.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var scoreTeamA: Int = 0
    private var scoreTeamB: Int = 0

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }





    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activityMainBinding.root)

        with(activityMainBinding) {
            equipeASomar1.setOnClickListener {
                scoreTeamA++
                equipeAScore.apply{text = scoreTeamA.toString()}
            }
            equipeBSomar1.setOnClickListener {
                scoreTeamB++
                equipeBScore.apply{text = scoreTeamB.toString()}
            }
            equipeASomar3.setOnClickListener {
                scoreTeamA += 3
                equipeAScore.apply{text = scoreTeamA.toString()}
            }
            equipeBSomar3.setOnClickListener {
                scoreTeamB += 3
                equipeBScore.apply{text = scoreTeamB.toString()}
            }

            resetGame.setOnClickListener {
                scoreTeamA = 0
                scoreTeamB = 0
                equipeAScore.apply { text = scoreTeamA.toString() }
                equipeBScore.apply { text = scoreTeamB.toString() }
            }
        }

    }
}