package milu.kiriu2010.miluand01.c1x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.c1x.c11.C11Fragment

class C1XActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c1_x)

        // デフォルトのフラグメントを配置
        changeFragment("c11")

        // アクションバーに戻るボタンを設ける
        // これだけでは、ボタンを押しても、前画面に戻らない
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            //setHomeButtonEnabled(true)
        }
    }

    // 表示するフラグメントを切り替える
    private fun changeFragment(tag: String) {
        val fragment = when (tag) {
            "c11" -> C11Fragment.newInstance()
            else -> C11Fragment.newInstance()
        }

        // 現在表示しているフラグメントをスタックから外す
        supportFragmentManager.popBackStack()
        // 選択したフラグメントを表示する
        if ( supportFragmentManager.findFragmentByTag(tag) == null ) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flC1X, fragment, tag)
                .commit()
        }
    }
}
