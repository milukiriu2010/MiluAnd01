package milu.kiriu2010.miluand01.c0x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.c0x.c01.C01AFragment
import milu.kiriu2010.miluand01.c0x.c01.C01BFragment
import milu.kiriu2010.miluand01.c0x.c01.C01CFragment
import milu.kiriu2010.miluand01.c0x.c02.C02Fragment

class C0XActivity : AppCompatActivity() {

    val FRG = "fragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c0_x)

        // 回転すると、結局onCreateが呼ばれて、新しいフラグメントが生成される
        Log.d(javaClass.simpleName,"onCreate")

        if ( savedInstanceState != null ) {
            val frgName = savedInstanceState.getString(FRG)
            val frg = supportFragmentManager.findFragmentByTag(frgName)
            frg?.let {
                supportFragmentManager.beginTransaction()
                    .show(it)
                    .commit()
            }
        }
        else {
            // デフォルトのフラグメントを配置
            changeFragment(C01CFragment.newInstance())
        }

        // アクションバーに戻るボタンを設ける
        // これだけでは、ボタンを押しても、前画面に戻らない
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            //setHomeButtonEnabled(true)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val fragment = supportFragmentManager.fragments.first()

        outState.putString(FRG,fragment.javaClass.simpleName)
    }

    // アクションバーにメニューを表示する
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_c0x, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(javaClass.simpleName,"itemId:{${item.itemId}}")
        Log.d(javaClass.simpleName,"C01:{${R.id.itemC01A}}")
        Log.d(javaClass.simpleName,"C02:{${R.id.itemC02}}")
        return when (item.itemId) {
            // 前画面に戻る
            android.R.id.home -> {
                finish()
                true
            }
            // C01:CheckBox:No ViewModel
            R.id.itemC01A -> {
                changeFragment(C01AFragment.newInstance())
                true
            }
            // C01:CheckBox:ViewModel
            R.id.itemC01B -> {
                changeFragment(C01BFragment.newInstance())
                true
            }
            // C01:CheckBox:LiveData
            R.id.itemC01C -> {
                changeFragment(C01CFragment.newInstance())
                true
            }
            // C02:RadioButton
            R.id.itemC02 -> {
                changeFragment(C02Fragment.newInstance())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // 表示するフラグメントを切り替える
    private fun changeFragment(fragment: Fragment) {
        // 現在表示しているフラグメントをスタックから外す
        //supportFragmentManager.popBackStack()
        // 選択したフラグメントを表示する
        val frg = supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName)
        if ( frg == null ) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flC0X, fragment, fragment.javaClass.simpleName)
                .commit()
        }
        else {
            supportFragmentManager.beginTransaction()
                .show(frg)
                .commit()
        }
    }
}
