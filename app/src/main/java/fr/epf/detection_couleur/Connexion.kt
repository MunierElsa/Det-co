package fr.epf.detection_couleur

import android.content.Intent
import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConnexionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)

        var mPlayer: MediaPlayer? = null

        val mail = findViewById<TextView>(R.id.mail)
        val mdp = findViewById<TextView>(R.id.mdp)
        val mail_adresse = findViewById<EditText>(R.id.EmailAddress)
        val password = findViewById<EditText>(R.id.Password)
        val connexion = findViewById<Button>(R.id.button_connexion)
        val typeface = Typeface.createFromAsset(applicationContext.assets, "assets/Luciole-Regular.ttf")
        mail.setTypeface(typeface)
        mdp.setTypeface(typeface)
        mail_adresse.setTypeface(typeface)
        password.setTypeface(typeface)
        connexion.setTypeface(typeface)

        mail_adresse.setOnClickListener {
            mPlayer = MediaPlayer.create(this,R.raw.adresse_mail)
            mPlayer!!.start()
        }

        password.setOnClickListener {
            mPlayer = MediaPlayer.create(this,R.raw.passe)
            mPlayer!!.start()
        }
        connexion.setOnClickListener {
            mPlayer = MediaPlayer.create(this,R.raw.connecte)
            mPlayer!!.start()
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}