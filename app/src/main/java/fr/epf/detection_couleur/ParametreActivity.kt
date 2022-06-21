package fr.epf.detection_couleur

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class ParametreActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parameter)

        var mPlayer: MediaPlayer? = null

        val langue_titre = findViewById<TextView>(R.id.langue_titre)
        val validate = findViewById<Button>(R.id.validate)
        val devise_titre = findViewById<TextView>(R.id.devise_titre)
        val typeface = Typeface.createFromAsset(applicationContext.assets, "assets/Luciole-Regular.ttf")
        langue_titre.setTypeface(typeface)
        devise_titre.setTypeface(typeface)
        validate.setTypeface(typeface)


        val mSpinner = findViewById<Spinner>(R.id.langues)
        val mList = arrayOf<String?>("Allemand", "Anglais", "Espagnol", "Français", "Italien", "Japonais", "Néerlandais", "Turc")
        val mArrayAdapter = ArrayAdapter<Any?>(this, R.layout.activity_spinner, mList)
        mArrayAdapter.setDropDownViewResource(R.layout.activity_spinner)
        mSpinner.adapter = mArrayAdapter

        val mSpinner2 = findViewById<Spinner>(R.id.devises)
        val mList2 = arrayOf<String?>("Dollar Américain", "Euro", "Yen Japonais", "Livre Sterling", "Dollar Australien", "Dollar Canadien", "Franc Suisse", "Renminbi Chinois")
        val mArrayAdapter2 = ArrayAdapter<Any?>(this, R.layout.activity_spinner, mList2)
        mArrayAdapter2.setDropDownViewResource(R.layout.activity_spinner)
        mSpinner2.adapter = mArrayAdapter2


        validate.setOnClickListener {
            mPlayer = MediaPlayer.create(this,R.raw.valider)
            mPlayer!!.start()
            startActivity(Intent(this, MainActivity2::class.java))
            Toast.makeText(this, "Les paramètres ont été enregistrés", Toast.LENGTH_LONG)
                .show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

}