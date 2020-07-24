package milu.kiriu2010.entity.team0

import kotlinx.android.parcel.Parcelize
import milu.kiriu2010.miluand01.R
import java.text.SimpleDateFormat
import java.util.*

// ------------------------------------------
// 野球チームのクラス
// ------------------------------------------
@Parcelize
data class Team0BaseBall(
    override var type: String = "",
    override var name: String = "",
    override var playerLst: List<Player> = mutableListOf(),
    override var yearPosMap: Map<Int, Int> = mutableMapOf(),
    override var logo: Int = R.drawable.ic_main,
    var league: LeagueBaseBall = LeagueBaseBall.UNKNOWN
): Team0Abs {

    companion object {
        // ------------------------------------------
        // 野球チームのリストを生成
        // ------------------------------------------
        fun createLst(): MutableList<Team0Abs> {
            val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
            // 阪神
            val htNish = Player("勇輝","西", dateFormat.parse("19901110")!!)
            val htTaka = Player( "遥人","髙橋",dateFormat.parse("19951107")!!)
            // 巨人
            val ygSuga = Player( "智之","菅野",dateFormat.parse("19891011")!!)
            val ygTogo = Player( "翔征","戸郷",dateFormat.parse("20000404")!!)
            // 広島
            val hcOhse = Player( "大地","大瀬良",dateFormat.parse("19910617")!!)
            val hcMori = Player( "暢仁","森下",dateFormat.parse("19970825")!!)
            // 横浜
            val ydIman = Player( "昇太","今永",dateFormat.parse("19930901")!!)
            val ydHama = Player( "遥大","濵口",dateFormat.parse("19950316")!!)
            // ヤクルト
            val ysIshi = Player( "雅規","石川",dateFormat.parse("19800122")!!)
            val ysOgaw = Player( "泰弘","小川",dateFormat.parse("19900516")!!)
            // 中日
            val cdOhno = Player( "雄大","大野",dateFormat.parse("19880926")!!)
            val cdUmet = Player( "晃大","梅津",dateFormat.parse("19961024")!!)
            // ソフトバンク
            val shSeng = Player( "滉大","千賀",dateFormat.parse("19930130")!!)
            val shHiga = Player( "巨","東浜",dateFormat.parse("19900620")!!)
            // 西武
            val slTaka = Player( "光成","髙橋",dateFormat.parse("19970203")!!)
            val slYoza = Player( "海人","與座",dateFormat.parse("19950915")!!)
            // 楽天
            val reNori = Player( "昂大","則本",dateFormat.parse("19901217")!!)
            val reWaku = Player( "秀章","涌井",dateFormat.parse("19860621")!!)
            // ロッテ
            val lmMima = Player( "学","美馬",dateFormat.parse("19860919")!!)
            val lmTane = Player( "篤暉","種市",dateFormat.parse("19980907")!!)
            // 日ハム
            val nfKato = Player( "貴之","加藤",dateFormat.parse("19920603")!!)
            val nfArih = Player( "航平","有原",dateFormat.parse("19980907")!!)
            // オリックス
            val obYama = Player( "福也","山﨑",dateFormat.parse("19920909")!!)
            val obTaji = Player( "大樹","田嶋",dateFormat.parse("19960803")!!)

            // チーム一覧
            val tigers   = Team0BaseBall("baseball", "Tigers"  , mutableListOf(htNish,htTaka), mutableMapOf(2017 to 2, 2018 to 6, 2019 to 3), R.drawable.ic_baseball_tigers  , LeagueBaseBall.CENTRAL )
            val giants   = Team0BaseBall("baseball", "giants"  , mutableListOf(ygSuga,ygTogo), mutableMapOf(2017 to 4, 2018 to 3, 2019 to 1), R.drawable.ic_baseball_giants  , LeagueBaseBall.CENTRAL )
            val carp     = Team0BaseBall("baseball", "carp"    , mutableListOf(hcOhse,hcMori), mutableMapOf(2017 to 1, 2018 to 1, 2019 to 4), R.drawable.ic_baseball_carp    , LeagueBaseBall.CENTRAL )
            val baystars = Team0BaseBall("baseball", "baystars", mutableListOf(ydIman,ydHama), mutableMapOf(2017 to 3, 2018 to 4, 2019 to 2), R.drawable.ic_baseball_baystars, LeagueBaseBall.CENTRAL )
            val swallows = Team0BaseBall("baseball", "swallows", mutableListOf(ysIshi,ysOgaw), mutableMapOf(2017 to 6, 2018 to 2, 2019 to 6), R.drawable.ic_baseball_swallows, LeagueBaseBall.CENTRAL )
            val dragons  = Team0BaseBall("baseball", "dragons" , mutableListOf(cdOhno,cdUmet), mutableMapOf(2017 to 5, 2018 to 5, 2019 to 5), R.drawable.ic_baseball_dragons , LeagueBaseBall.CENTRAL )
            val hawks    = Team0BaseBall("baseball", "hawks"   , mutableListOf(shSeng,shHiga), mutableMapOf(2017 to 1, 2018 to 2, 2019 to 2), R.drawable.ic_baseball_hawks   , LeagueBaseBall.PACIFIC )
            val lions    = Team0BaseBall("baseball", "lions"   , mutableListOf(slTaka,slYoza), mutableMapOf(2017 to 2, 2018 to 1, 2019 to 1), R.drawable.ic_baseball_lions   , LeagueBaseBall.PACIFIC )
            val eagles   = Team0BaseBall("baseball", "eagles"  , mutableListOf(reNori,reWaku), mutableMapOf(2017 to 3, 2018 to 6, 2019 to 3), R.drawable.ic_baseball_eagles  , LeagueBaseBall.PACIFIC )
            val marines  = Team0BaseBall("baseball", "marines" , mutableListOf(lmMima,lmTane), mutableMapOf(2017 to 6, 2018 to 5, 2019 to 4), R.drawable.ic_baseball_marines , LeagueBaseBall.PACIFIC )
            val fighters = Team0BaseBall("baseball", "fighters", mutableListOf(nfKato,nfArih), mutableMapOf(2017 to 5, 2018 to 3, 2019 to 5), R.drawable.ic_baseball_fighters, LeagueBaseBall.PACIFIC )
            val buffalos = Team0BaseBall("baseball", "buffalos", mutableListOf(obYama,obTaji), mutableMapOf(2017 to 4, 2018 to 4, 2019 to 6), R.drawable.ic_baseball_buffalos, LeagueBaseBall.PACIFIC )

            return mutableListOf(tigers,giants,carp,baystars,swallows,dragons,hawks,lions,eagles,marines,fighters,buffalos)
        }
    }
}
