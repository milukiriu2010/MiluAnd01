package milu.kiriu2010.miluand01.c0x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.c0x.c01.C01Fragment

class C0XActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c0_x)

        Log.d(this.javaClass.simpleName,"ptn1")
        supportFragmentManager.popBackStack()
        if ( supportFragmentManager.findFragmentByTag("xyz") == null ) {
            Log.d(this.javaClass.simpleName,"ptn2")
            supportFragmentManager.beginTransaction()
                .replace(R.id.flC0X, C01Fragment.newInstance(), "xyz")
                .commit()
        }
    }
}
