package milu.kiriu2010.entity.team0

import milu.kiriu2010.miluand01.R

// ------------------------------------------
// 野球チームのクラス
// ------------------------------------------
data class Team0BaseBall(
    override var type: String = "",
    override var name: String = "",
    override var playerLst: List<String> = mutableListOf(),
    override var yearPosMap: Map<Int, Int> = mutableMapOf(),
    override var logo: Int = R.drawable.ic_main,
    var league: LeagueBaseBall = LeagueBaseBall.UNKNOWN
): Team0Abs {

    companion object {
        // ------------------------------------------
        // 野球チームのリストを生成
        // ------------------------------------------
        fun createLst(): MutableList<Team0Abs> {
            var tigers   = Team0BaseBall("baseball", "Tigers"  , mutableListOf("nishi"   ,"takahashi"), mutableMapOf(2017 to 2, 2018 to 6, 2019 to 3), R.drawable.ic_baseball_tigers  , LeagueBaseBall.CENTRAL )
            var giants   = Team0BaseBall("baseball", "giants"  , mutableListOf("sugano"  ,"takahashi"), mutableMapOf(2017 to 4, 2018 to 3, 2019 to 1), R.drawable.ic_baseball_giants  , LeagueBaseBall.CENTRAL )
            var carp     = Team0BaseBall("baseball", "carp"    , mutableListOf("osera"   ,"nomura")   , mutableMapOf(2017 to 1, 2018 to 1, 2019 to 4), R.drawable.ic_baseball_carp    , LeagueBaseBall.CENTRAL )
            var baystars = Team0BaseBall("baseball", "baystars", mutableListOf("imanaga" ,"hamaguchi"), mutableMapOf(2017 to 3, 2018 to 4, 2019 to 2), R.drawable.ic_baseball_baystars, LeagueBaseBall.CENTRAL )
            var swallows = Team0BaseBall("baseball", "swallows", mutableListOf("ishikawa","ogawa")    , mutableMapOf(2017 to 6, 2018 to 2, 2019 to 6), R.drawable.ic_baseball_swallows, LeagueBaseBall.CENTRAL )
            var dragons  = Team0BaseBall("baseball", "dragons" , mutableListOf("ohno"    ,"yanagi")   , mutableMapOf(2017 to 5, 2018 to 5, 2019 to 5), R.drawable.ic_baseball_dragons , LeagueBaseBall.CENTRAL )
            var hawks    = Team0BaseBall("baseball", "hawks"   , mutableListOf("senga"   ,"takahashi"), mutableMapOf(2017 to 1, 2018 to 2, 2019 to 2), R.drawable.ic_baseball_hawks   , LeagueBaseBall.PACIFIC )
            var lions    = Team0BaseBall("baseball", "lions"   , mutableListOf("imai"    ,"takahashi"), mutableMapOf(2017 to 2, 2018 to 1, 2019 to 1), R.drawable.ic_baseball_lions   , LeagueBaseBall.PACIFIC )
            var eagles   = Team0BaseBall("baseball", "eagles"  , mutableListOf("norimoto","kishi")    , mutableMapOf(2017 to 3, 2018 to 6, 2019 to 3), R.drawable.ic_baseball_eagles  , LeagueBaseBall.PACIFIC )
            var marines  = Team0BaseBall("baseball", "marines" , mutableListOf("ishikawa","mima")     , mutableMapOf(2017 to 6, 2018 to 5, 2019 to 4), R.drawable.ic_baseball_marines , LeagueBaseBall.PACIFIC )
            var fighters = Team0BaseBall("baseball", "fighters", mutableListOf("uesawa"  ,"kaneko")   , mutableMapOf(2017 to 5, 2018 to 3, 2019 to 5), R.drawable.ic_baseball_fighters, LeagueBaseBall.PACIFIC )
            var buffalos = Team0BaseBall("baseball", "buffalos", mutableListOf("yamaoka" ,"yamamoto") , mutableMapOf(2017 to 4, 2018 to 4, 2019 to 6), R.drawable.ic_baseball_buffalos, LeagueBaseBall.PACIFIC )

            return mutableListOf(tigers,giants,carp,baystars,swallows,dragons,hawks,lions,eagles,marines,fighters,buffalos)
        }
    }
}
