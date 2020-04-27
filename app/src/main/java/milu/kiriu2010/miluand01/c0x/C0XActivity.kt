package milu.kiriu2010.miluand01.c0x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.c0x.c01.C01Fragment
import milu.kiriu2010.miluand01.c0x.c02.C02Fragment

class C0XActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c0_x)

        // デフォルトのフラグメントを配置
        changeFragment("c01")

        // アクションバーに戻るボタンを設ける
        // これだけでは、ボタンを押しても、前画面に戻らない
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            //setHomeButtonEnabled(true)
        }
    }

    // アクションバーにメニューを表示する
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_c0x, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(javaClass.simpleName,"itemId:{${item.itemId}}")
        Log.d(javaClass.simpleName,"C01:{${R.id.itemC01}}")
        Log.d(javaClass.simpleName,"C02:{${R.id.itemC02}}")
        return when (item.itemId) {
            // 前画面に戻る
            android.R.id.home -> {
                finish()
                true
            }
            // C01:CheckBox
            R.id.itemC01 -> {
                changeFragment("c01")
                true
            }
            // C02:RadioButton
            R.id.itemC02 -> {
                changeFragment("c02")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // 表示するフラグメントを切り替える
    private fun changeFragment(tag: String) {
        val fragment = when (tag) {
            "c01" -> C01Fragment.newInstance()
            "c02" -> C02Fragment.newInstance()
            else -> C01Fragment.newInstance()
        }

        // 現在表示しているフラグメントをスタックから外す
        supportFragmentManager.popBackStack()
        // 選択したフラグメントを表示する
        if ( supportFragmentManager.findFragmentByTag(tag) == null ) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flC0X, fragment, tag)
                .commit()
        }
    }
}
