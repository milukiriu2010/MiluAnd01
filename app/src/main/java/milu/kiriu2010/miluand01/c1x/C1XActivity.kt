package milu.kiriu2010.miluand01.c1x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.c1x.c11.C11AFragment
import milu.kiriu2010.miluand01.c1x.c11.C11BFragment
import milu.kiriu2010.miluand01.c1x.c11.C11TeamListner
import milu.kiriu2010.miluand01.c2x.c12.C12AFragment

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

    // アクションバーにメニューを表示する
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_c1x, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            // C11:Teams:No ViewModel
            R.id.itemC11 -> {
                changeFragment(C11AFragment.newInstance())
                true
            }
            // C12:Teams:DataBinding
            R.id.itemC12 -> {
                changeFragment(C12AFragment.newInstance())
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
