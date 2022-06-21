package fr.epf.detection_couleur

import android.content.Intent
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mPlayer: MediaPlayer? = null

        val titre = findViewById<TextView>(R.id.titre)
        val batterie = findViewById<TextView>(R.id.batterie)
        val batterie_image = findViewById<ImageView>(R.id.image_batterie)
        val traduction = findViewById<Button>(R.id.button_traduction)
        val connexion = findViewById<Button>(R.id.button_connexion)
        val parametre = findViewById<ImageView>(R.id.image_parametre)
        val typeface = Typeface.createFromAsset(applicationContext.assets, "assets/Luciole-Regular.ttf")
        titre.setTypeface(typeface)
        batterie.setTypeface(typeface)
        traduction.setTypeface(typeface)
        connexion.setTypeface(typeface)

        mPlayer = MediaPlayer.create(this,R.raw.phraselongue)
        mPlayer!!.start()

        val builder = AlertDialog.Builder(this).setTitle("Données")
            .setMessage(R.string.confirm_donnees)
            .setPositiveButton(R.string.yes) { _, _ ->
                Toast.makeText(this, "Les données seront enregistrées", Toast.LENGTH_LONG)
                    .show()
                mPlayer = MediaPlayer.create(this,R.raw.oui)
                mPlayer!!.start()
            }.setNegativeButton(R.string.no) { _, _ ->
                Toast.makeText(this, "Les données ne seront pas enregistrées", Toast.LENGTH_LONG)
                    .show()
                mPlayer = MediaPlayer.create(this,R.raw.non)
                mPlayer!!.start()

            }
        builder.show()

        batterie_image.setOnClickListener {
            mPlayer = MediaPlayer.create(this,R.raw.batterie)
            mPlayer!!.start()
        }
        parametre.setOnClickListener {
            mPlayer = MediaPlayer.create(this,R.raw.parametres)
            mPlayer!!.start()
            startActivity(Intent(this, ParametreActivity::class.java))
        }
        traduction.setOnClickListener {
            mPlayer = MediaPlayer.create(this,R.raw.traduction)
            mPlayer!!.start()
            startActivity(Intent(this, TraductionActivity::class.java))
        }
        connexion.setOnClickListener {
            mPlayer = MediaPlayer.create(this,R.raw.connexion)
            mPlayer!!.start()
            startActivity(Intent(this, ConnexionActivity::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}