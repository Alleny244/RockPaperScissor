package com.example.rockpaperscissor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_main)
        var i:Int=1;
        var userScore = 0
        var computerScore = 0

        var computerChoice:String;
        var userChoice:String;
        var mApp = MyApplication()
        var count = mApp.n


        play.setOnClickListener{

                var randos=(0..2).random();
                var game =arrayOf("rock","paper","scissors");
                computerChoice=game[randos]
                userChoice= getResources().getResourceEntryName(radioGroup.checkedRadioButtonId)

                if (userChoice == computerChoice){
                    if(userChoice=="rock"){
                        yourPicture.setImageResource(R.drawable.rock)
                        computerPicture.setImageResource(R.drawable.rock)
                    }
                    else if(userChoice=="paper"){
                        yourPicture.setImageResource(R.drawable.paper)
                        computerPicture.setImageResource(R.drawable.paper)
                    }
                    else {
                        yourPicture.setImageResource(R.drawable.scissors)
                        computerPicture.setImageResource(R.drawable.scissors)
                    }
                    Toast.makeText(this, "Tie You Both Entered Same", Toast.LENGTH_SHORT).show()
                }

                else if (userChoice == "rock"){
                    if(computerChoice == "paper"){
                        yourPicture.setImageResource(R.drawable.rock)
                        computerPicture.setImageResource(R.drawable.paper)
                        Toast.makeText(this, "\uD83D\uDC49 You lose! Paper covers Rock", Toast.LENGTH_SHORT).show()
                        computerScore += 1
                    }
                    else{
                        yourPicture.setImageResource(R.drawable.rock)
                        computerPicture.setImageResource(R.drawable.scissors)
                        Toast.makeText(this, "\uD83D\uDC49 You win! Rock smashes Scissors", Toast.LENGTH_SHORT).show()
                        userScore += 1
                    }
                }
                else if (userChoice == "paper"){

                    if(computerChoice == "scissors"){
                        yourPicture.setImageResource(R.drawable.paper)
                        computerPicture.setImageResource(R.drawable.scissors)
                        Toast.makeText(this, "\uD83D\uDC49 You lose! Scissor cut Paper", Toast.LENGTH_SHORT).show()
                        computerScore += 1
                    }
                    else{
                        yourPicture.setImageResource(R.drawable.paper)
                        computerPicture.setImageResource(R.drawable.rock)
                        Toast.makeText(this, "\uD83D\uDC49 You win! Paper covers Rock", Toast.LENGTH_SHORT).show()
                        userScore += 1
                    }
                }
                else if (userChoice == "scissors"){
                    if (computerChoice == "rock"){
                        yourPicture.setImageResource(R.drawable.scissors)
                        computerPicture.setImageResource(R.drawable.rock)
                        Toast.makeText(this, "\uD83D\uDC49 You lose! Rock smashes Scissors", Toast.LENGTH_SHORT).show()
                        computerScore += 1
                    }
                    else{
                        yourPicture.setImageResource(R.drawable.scissors)
                        computerPicture.setImageResource(R.drawable.paper)
                        Toast.makeText(this, "\uD83D\uDC49 You win! Scissor cut Paper", Toast.LENGTH_SHORT).show()
                        userScore += 1
                    }
                }
                yScore.text=userScore.toString()
                cScore.text=computerScore.toString()




        if (userScore < computerScore){
            winner.text="😭 Sorry You lose the game 😭"
        }
        else if(userScore == computerScore){
            winner.text="😅 Game is Tie Play Again 😅"
        }
        else{
            winner.text="😄 You Win the Game"
        }


    }
        reset.setOnClickListener{
            userScore = 0
            computerScore = 0
            yScore.text=userScore.toString()
            cScore.text=computerScore.toString()
            winner.text=""
            yourPicture.setImageResource(0)
            computerPicture.setImageResource(0)


        }


    }
}