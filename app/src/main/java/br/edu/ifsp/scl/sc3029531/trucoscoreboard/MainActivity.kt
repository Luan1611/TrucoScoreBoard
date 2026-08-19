package br.edu.ifsp.scl.sc3029531.trucoscoreboard

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sc3029531.trucoscoreboard.databinding.ActivityMainBinding
import kotlin.toString

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

                    buildAlertDialog(context = root.context, equipe = "Equipe A", scoreTeamA,
                        scoreTeamB,
                        equipeAScore,
                        equipeBScore,
                        equipeASomar3,
                        equipeBSomar3,
                        fun() {
                            scoreTeamA = 0
                            scoreTeamB = 0
                        }
                    )
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

                    buildAlertDialog(context = root.context, equipe = "Equipe B", scoreTeamA,
                        scoreTeamB,
                        equipeAScore,
                        equipeBScore,
                        equipeASomar3,
                        equipeBSomar3,
                        fun() {
                            scoreTeamA = 0
                            scoreTeamB = 0
                        }
                    )
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

                    buildAlertDialog(context = root.context, equipe = "Equipe A", scoreTeamA,
                        scoreTeamB,
                        equipeAScore,
                        equipeBScore,
                        equipeASomar3,
                        equipeBSomar3,
                        fun() {
                            scoreTeamA = 0
                            scoreTeamB = 0
                        })
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

                    buildAlertDialog(context = root.context, equipe = "Equipe B", scoreTeamA,
                        scoreTeamB,
                        equipeAScore,
                        equipeBScore,
                        equipeASomar3,
                        equipeBSomar3,
                        fun() {
                            scoreTeamA = 0
                            scoreTeamB = 0
                            }
                    )
                }
            }

            resetGame.setOnClickListener{

                restartGame(scoreTeamA,
                    scoreTeamB,
                    equipeAScore,
                    equipeBScore,
                    equipeASomar3,
                    equipeBSomar3,
                    fun() {
                        scoreTeamA = 0
                        scoreTeamB = 0
                    }
                )


            }
        }

    }

}

fun restartGame(scoreA: Int, scoreB: Int, pontuacaoA: TextView, pontuacaoB: TextView, btA: Button, btB: Button, resetValues: () -> Unit) {
    resetValues()
    btA.isEnabled = true
    btB.isEnabled = true
    pontuacaoA.apply { text = scoreA.toString() }
    pontuacaoB.apply { text = scoreB.toString() }

}

fun buildAlertDialog(context: Context, equipe: String, scoreA: Int, scoreB: Int, pontuacaoA: TextView, pontuacaoB: TextView, btA: Button, btB: Button, resetValues: () -> Unit) {
    AlertDialog.Builder(context)
        .setTitle("Fim de jogo!")
        .setMessage("A ${equipe} venceu a partida!")
        .setPositiveButton("Reiniciar partida") {dialog, _ ->
            restartGame(
                scoreA,
                scoreB,
                pontuacaoA,
                pontuacaoB,
                btA,
                btB,
                resetValues
            )
        }
        .setOnDismissListener {
            restartGame(
                scoreA,
                scoreB,
                pontuacaoA,
                pontuacaoB,
                btA,
                btB,
                resetValues
            )
        }
        .show()
}