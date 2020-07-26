package milu.kiriu2010.miluand01.c2x

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.c2x.c21.C21AFragment

class C2XActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c2_x)

        // デフォルトのフラグメントを配置
        changeFragment(C21AFragment.newInstance())

        // アクションバーに戻るボタンを設ける
        // これだけでは、ボタンを押しても、前画面に戻らない
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            //setHomeButtonEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        Log.d(javaClass.simpleName,"backStackEntryCount:${supportFragmentManager.backStackEntryCount}")
        if ( supportFragmentManager.backStackEntryCount > 1 ) {
            supportFragmentManager.popBackStack()
        }
        else {
            supportFragmentManager.popBackStack()
            super.onBackPressed()
        }
    }

    // 表示するフラグメントを切り替える
    private fun changeFragment(fragment: Fragment) {
        // 現在表示しているフラグメントをスタックから外す
        //supportFragmentManager.popBackStack()
        // 選択したフラグメントを表示する
        val tag = fragment.javaClass.simpleName
        if ( supportFragmentManager.findFragmentByTag(tag) == null ) {
            supportFragmentManager.beginTransaction()
                .add(R.id.flC2X, fragment, tag)
                .addToBackStack(tag)
                .commit()
        }
    }
}
