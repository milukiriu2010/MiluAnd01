package milu.kiriu2010.entity.team0

import kotlinx.android.parcel.Parcelize
import milu.kiriu2010.miluand01.R
import java.text.SimpleDateFormat
import java.util.*

// ------------------------------------------
// サッカーチームのクラス
// ------------------------------------------
@Parcelize
data class Team0Soccer(
    override var type: String = "",
    override var name: String = "",
    override var playerLst: List<Player> = mutableListOf(),
    override var yearPosMap: Map<Int, Int> = mutableMapOf(),
    override var logo: Int = R.drawable.ic_main,
    var level: Int = -1
) : Team0Abs {
    companion object {
        // ------------------------------------------
        // サッカーチームのリストを生成
        // ------------------------------------------
        fun createLst(): MutableList<Team0Abs> {
            val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
            // フロンターレ
            val kfDami = Player( "レアンドロ","ダミアン",dateFormat.parse("19890722")!!)
            val kfKoba = Player( "悠","小林",dateFormat.parse("19890722")!!)
            // アントラーズ
            val kaItoh = Player( "翔","伊藤",dateFormat.parse("19880724")!!)
            val kaSome = Player( "唯月","染野",dateFormat.parse("20010912")!!)
            // セレッソ
            val coKaki = Player( "曜一朗","柿谷",dateFormat.parse("19900103")!!)
            val coToku = Player( "賢","都倉",dateFormat.parse("19860616")!!)
            // ベルディ
            val tvOkub = Player( "嘉人","大久保",dateFormat.parse("19820609")!!)
            val tvHana = Player( "仁","端戸",dateFormat.parse("19900531")!!)
            // ゼルビア
            val mzOkad = Player( "優希","岡田",dateFormat.parse("19960513")!!)
            val mzAndo = Player( "瑞季","安藤",dateFormat.parse("19990719")!!)

            // チーム一覧
            val frontale = Team0Soccer( "soccer", "frontale", mutableListOf(kfDami,kfKoba), mutableMapOf(2017 to  1, 2018 to 1, 2019 to  4), R.drawable.ic_soccer_frontale, 1)
            val antlers  = Team0Soccer( "soccer", "antlers" , mutableListOf(kaItoh,kaSome), mutableMapOf(2017 to  2, 2018 to 3, 2019 to  3), R.drawable.ic_soccer_antlers , 1)
            val cerezo   = Team0Soccer( "soccer", "cerezo"  , mutableListOf(coKaki,coToku), mutableMapOf(2017 to  3, 2018 to 7, 2019 to  5), R.drawable.ic_soccer_cerezo  , 1)
            val verdy    = Team0Soccer( "soccer", "verdy"   , mutableListOf(tvOkub,tvHana), mutableMapOf(2017 to  5, 2018 to 6, 2019 to 13), R.drawable.ic_soccer_verdy   , 2)
            val zelvia   = Team0Soccer( "soccer", "zelvia"  , mutableListOf(mzOkad,mzAndo), mutableMapOf(2017 to 16, 2018 to 4, 2019 to 18), R.drawable.ic_soccer_zelvia  , 2)

            return mutableListOf(frontale,antlers,cerezo,verdy,zelvia)
        }
    }
}
