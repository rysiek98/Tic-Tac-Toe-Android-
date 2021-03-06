package com.example.xoro
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlinx.android.synthetic.main.activity_game.*


class Game : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        fullScreen()

        val bundle :Bundle ?=intent.extras
        val gameType = bundle!!.getString("ID_gameType")
        var playervsPlayer = false
        if(gameType == "Player vs Player"){
         playervsPlayer = true
        }

        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.music)
        mediaPlayer?.start()

        var player = Player.X
        val gameBoard = arrayListOf<Field>()
        var moves = 0
        val buttons = arrayListOf<Button>()
        //Game buttons add to buttons list
        buttons.add(b1)
        buttons.add(b2)
        buttons.add(b3)
        buttons.add(b4)
        buttons.add(b5)
        buttons.add(b6)
        buttons.add(b7)
        buttons.add(b8)
        buttons.add(b9)
        //Each game field has neighbours
        gameBoard.add(Field(1, arrayOf(Directions.South,Directions.East, Directions.South_East)))
        gameBoard.add(Field(2, arrayOf(Directions.South,Directions.East, Directions.West)))
        gameBoard.add(Field(3, arrayOf(Directions.South,Directions.South_West, Directions.West)))
        gameBoard.add(Field(4, arrayOf(Directions.South,Directions.East,Directions.North)))
        gameBoard.add(Field(5, arrayOf(Directions.South,Directions.East, Directions.South_West,Directions.South_East,Directions.North, Directions.North_West, Directions.Nort_East, Directions.West)))
        gameBoard.add(Field(6, arrayOf(Directions.South,Directions.West,Directions.North)))
        gameBoard.add(Field(7, arrayOf(Directions.East,Directions.North, Directions.Nort_East)))
        gameBoard.add(Field(8, arrayOf(Directions.East, Directions.West, Directions.North)))
        gameBoard.add(Field(9, arrayOf(Directions.West, Directions.North, Directions.North_West)))

        val animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim)
            b1.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b1,showPlayer ,winner, buttons,0,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b1.isClickable = false
                b1.startAnimation(animation)
            }

            b2.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b2,showPlayer ,winner,buttons,1,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b2.isClickable = false
                b2.startAnimation(animation)
            }

            b3.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b3,showPlayer ,winner,buttons,2,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b3.isClickable = false
                b3.startAnimation(animation)
            }

            b4.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b4,showPlayer ,winner,buttons,3,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b4.isClickable = false
                b4.startAnimation(animation)
            }

            b5.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b5,showPlayer ,winner,buttons,4,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b5.isClickable = false
                b5.startAnimation(animation)
            }

            b6.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b6,showPlayer ,winner,buttons,5,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b6.isClickable = false
                b6.startAnimation(animation)
            }

            b7.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b7,showPlayer ,winner,buttons,6,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b7.isClickable = false
                b7.startAnimation(animation)
            }

            b8.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b8,showPlayer ,winner,buttons,7,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b8.isClickable = false
                b8.startAnimation(animation)
            }

            b9.setOnClickListener {
                moves += 1
                player = play(gameBoard, player,b9,showPlayer ,winner,buttons,8,moves, playervsPlayer, animation)
                if(!playervsPlayer){
                    Handler().postDelayed({moves = moveAI(showPlayer, gameBoard, winner, buttons, moves, animation)},750)
                }
                b9.isClickable = false
                b9.startAnimation(animation)
            }

            end.setOnClickListener {
                mediaPlayer?.stop()
                finish()
            }

            reset.setOnClickListener {
                for(i in 0..8){
                    gameBoard[i].setOwner(Owner.empty)
                }
                player = Player.X
                moves = 0
                resetGame(showPlayer ,winner,buttons)
            }

    }

    fun fullScreen(){
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

}

