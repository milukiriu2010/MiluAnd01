package milu.kiriu2010.miluand01.c1x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.c1x.c11.C11AFragment
import milu.kiriu2010.miluand01.c1x.c11.C11BFragment
import milu.kiriu2010.miluand01.c1x.c11.C11TeamListner

class C1XActivity : AppCompatActivity(), C11TeamListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c1_x)

        // デフォルトのフラグメントを配置
        changeFragment(C11AFragment.newInstance())

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
                .add(R.id.flC1X, fragment, tag)
                .addToBackStack(tag)
                .commit()
        }
    }

    override fun onTeamSelected(team0Abs: Team0Abs) {
        changeFragment(C11BFragment.newInstance(team0Abs))
    }
}
