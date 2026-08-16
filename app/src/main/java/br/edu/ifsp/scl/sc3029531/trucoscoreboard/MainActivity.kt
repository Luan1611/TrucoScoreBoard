package br.edu.ifsp.scl.sc3029531.trucoscoreboard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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

                if (scoreTeamA == 11) {
                    equipeASomar3.isEnabled = false

                    Toast.makeText(
                        root.context,
                        "A equipe A entrou na mão de onze",
                        Toast.LENGTH_LONG
                    ).show()
                }

                if (scoreTeamA > 11) {
                    AlertDialog.Builder(root.context)
                        .setTitle("Fim de jogo!")
                        .setMessage("A equipe A venceu a partida!")
                        .setPositiveButton("Reiniciar partida") {dialog, _ ->
                            scoreTeamA = 0
                            scoreTeamB = 0
                            equipeAScore.apply { text = scoreTeamA.toString() }
                            equipeBScore.apply { text = scoreTeamB.toString() }
                            equipeASomar3.isEnabled = true
                            equipeBSomar3.isEnabled = true
                        }
                        .setOnDismissListener {
                            scoreTeamA = 0
                            scoreTeamB = 0
                            equipeAScore.apply { text = scoreTeamA.toString() }
                            equipeBScore.apply { text = scoreTeamB.toString() }
                            equipeASomar3.isEnabled = true
                            equipeBSomar3.isEnabled = true
                        }
                        .show()
                }
            }

            equipeBSomar1.setOnClickListener {
                scoreTeamB++
                equipeBScore.apply{text = scoreTeamB.toString()}

                if (scoreTeamB == 11) {
                    equipeBSomar3.isEnabled = false

                    Toast.makeText(
                        root.context,
                        "A equipe B entrou na mão de onze",
                        Toast.LENGTH_LONG
                    ).show()
                }

                if (scoreTeamB > 11) {
                    AlertDialog.Builder(root.context)
                        .setTitle("Fim de jogo!")
                        .setMessage("A equipe B venceu a partida!")
                        .setPositiveButton("Reiniciar partida") {dialog, _ ->
                            scoreTeamA = 0
                            scoreTeamB = 0
                            equipeAScore.apply { text = scoreTeamA.toString() }
                            equipeBScore.apply { text = scoreTeamB.toString() }
                            equipeASomar3.isEnabled = true
                            equipeBSomar3.isEnabled = true
                        }
                        .setOnDismissListener {
                            scoreTeamA = 0
                            scoreTeamB = 0
                            equipeAScore.apply { text = scoreTeamA.toString() }
                            equipeBScore.apply { text = scoreTeamB.toString() }
                            equipeASomar3.isEnabled = true
                            equipeBSomar3.isEnabled = true
                        }
                        .show()
                }
            }

            equipeASomar3.setOnClickListener {
                scoreTeamA += 3
                equipeAScore.apply{text = scoreTeamA.toString()}

                if (scoreTeamA == 11) {
                    equipeASomar3.isEnabled = false

                    Toast.makeText(
                        root.context,
                        "A equipe A entrou na mão de onze",
                        Toast.LENGTH_LONG
                    ).show()
                }

                if (scoreTeamA > 11) {
                    AlertDialog.Builder(root.context)
                        .setTitle("Fim de jogo!")
                        .setMessage("A equipe A venceu a partida!")
                        .setPositiveButton("Reiniciar partida") {dialog, _ ->
                            scoreTeamA = 0
                            scoreTeamB = 0
                            equipeAScore.apply { text = scoreTeamA.toString() }
                            equipeBScore.apply { text = scoreTeamB.toString() }
                            equipeASomar3.isEnabled = true
                            equipeBSomar3.isEnabled = true
                        }
                        .setOnDismissListener {
                            scoreTeamA = 0
                            scoreTeamB = 0
                            equipeAScore.apply { text = scoreTeamA.toString() }
                            equipeBScore.apply { text = scoreTeamB.toString() }
                            equipeASomar3.isEnabled = true
                            equipeBSomar3.isEnabled = true
                        }
                        .show()
                }
            }

            equipeBSomar3.setOnClickListener {
                scoreTeamB += 3
                equipeBScore.apply{text = scoreTeamB.toString()}

                if (scoreTeamB == 11) {
                    equipeBSomar3.isEnabled = false

                    Toast.makeText(
                        root.context,
                        "A equipe B entrou na mão de onze",
                        Toast.LENGTH_LONG
                    ).show()
                }

                if (scoreTeamB > 11) {
                    AlertDialog.Builder(root.context)
                        .setTitle("Fim de jogo!")
                        .setMessage("A equipe B venceu a partida!")
                        .setPositiveButton("Reiniciar partida") {dialog, _ ->
                            scoreTeamA = 0
                            scoreTeamB = 0
                            equipeAScore.apply { text = scoreTeamA.toString() }
                            equipeBScore.apply { text = scoreTeamB.toString() }
                            equipeASomar3.isEnabled = true
                            equipeBSomar3.isEnabled = true
                        }
                        .setOnDismissListener {
                            scoreTeamA = 0
                            scoreTeamB = 0
                            equipeAScore.apply { text = scoreTeamA.toString() }
                            equipeBScore.apply { text = scoreTeamB.toString() }
                            equipeASomar3.isEnabled = true
                            equipeBSomar3.isEnabled = true
                        }
                        .show()
                }
            }

            resetGame.setOnClickListener {
                scoreTeamA = 0
                scoreTeamB = 0
                equipeASomar3.isEnabled = true
                equipeBSomar3.isEnabled = true
                equipeAScore.apply { text = scoreTeamA.toString() }
                equipeBScore.apply { text = scoreTeamB.toString() }
            }
        }

    }
}