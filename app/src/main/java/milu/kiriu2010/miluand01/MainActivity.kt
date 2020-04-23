package milu.kiriu2010.miluand01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import milu.kiriu2010.miluand01.c0x.C0XActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // C0Xページへ遷移
        btnC0X.setOnClickListener {
            val intent = Intent(this, C0XActivity::class.java)
            startActivity(intent)
        }
    }
}
