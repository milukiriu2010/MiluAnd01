package milu.kiriu2010.entity.team

import milu.kiriu2010.miluand01.R

// ------------------------------------------
// 野球チームのクラス
// ------------------------------------------
data class TeamBaseBall(
    override var type: String = "",
    override var name: String = "",
    override var playerLst: List<String> = mutableListOf(),
    override var yearPosMap: Map<Int, Int> = mutableMapOf(),
    override var logo: Int = R.drawable.ic_main,
    var league: LeagueBaseBall = LeagueBaseBall.UNKNOWN
): TeamAbs {

    companion object {
        // ------------------------------------------
        // 野球チームのリストを生成
        // ------------------------------------------
        fun createLst(): MutableList<TeamAbs> {
            var tigers   = TeamBaseBall("baseball", "Tigers"  , mutableListOf("nishi"   ,"takahashi"), mutableMapOf(2017 to 2, 2018 to 6, 2019 to 3), R.drawable.ic_baseball_tigers  , LeagueBaseBall.CENTRAL )
            var giants   = TeamBaseBall("baseball", "giants"  , mutableListOf("sugano"  ,"takahashi"), mutableMapOf(2017 to 4, 2018 to 3, 2019 to 1), R.drawable.ic_baseball_giants  , LeagueBaseBall.CENTRAL )
            var carp     = TeamBaseBall("baseball", "carp"    , mutableListOf("osera"   ,"nomura")   , mutableMapOf(2017 to 1, 2018 to 1, 2019 to 4), R.drawable.ic_baseball_carp    , LeagueBaseBall.CENTRAL )
            var baystars = TeamBaseBall("baseball", "baystars", mutableListOf("imanaga" ,"hamaguchi"), mutableMapOf(2017 to 3, 2018 to 4, 2019 to 2), R.drawable.ic_baseball_baystars, LeagueBaseBall.CENTRAL )
            var swallows = TeamBaseBall("baseball", "swallows", mutableListOf("ishikawa","ogawa")    , mutableMapOf(2017 to 6, 2018 to 2, 2019 to 6), R.drawable.ic_baseball_swallows, LeagueBaseBall.CENTRAL )
            var dragons  = TeamBaseBall("baseball", "dragons" , mutableListOf("ohno"    ,"yanagi")   , mutableMapOf(2017 to 5, 2018 to 5, 2019 to 5), R.drawable.ic_baseball_dragons , LeagueBaseBall.CENTRAL )
            var hawks    = TeamBaseBall("baseball", "hawks"   , mutableListOf("senga"   ,"takahashi"), mutableMapOf(2017 to 1, 2018 to 2, 2019 to 2), R.drawable.ic_baseball_hawks   , LeagueBaseBall.PACIFIC )
            var lions    = TeamBaseBall("baseball", "lions"   , mutableListOf("imai"    ,"takahashi"), mutableMapOf(2017 to 2, 2018 to 1, 2019 to 1), R.drawable.ic_baseball_lions   , LeagueBaseBall.PACIFIC )
            var eagles   = TeamBaseBall("baseball", "eagles"  , mutableListOf("norimoto","kishi")    , mutableMapOf(2017 to 3, 2018 to 6, 2019 to 3), R.drawable.ic_baseball_eagles  , LeagueBaseBall.PACIFIC )
            var marines  = TeamBaseBall("baseball", "marines" , mutableListOf("ishikawa","mima")     , mutableMapOf(2017 to 6, 2018 to 5, 2019 to 4), R.drawable.ic_baseball_marines , LeagueBaseBall.PACIFIC )
            var fighters = TeamBaseBall("baseball", "fighters", mutableListOf("uesawa"  ,"kaneko")   , mutableMapOf(2017 to 5, 2018 to 3, 2019 to 5), R.drawable.ic_baseball_fighters, LeagueBaseBall.PACIFIC )
            var buffalos = TeamBaseBall("baseball", "buffalos", mutableListOf("yamaoka" ,"yamamoto") , mutableMapOf(2017 to 4, 2018 to 4, 2019 to 6), R.drawable.ic_baseball_buffalos, LeagueBaseBall.PACIFIC )

            return mutableListOf(tigers,giants,carp,baystars,swallows,dragons,hawks,lions,eagles,marines,fighters,buffalos)
        }
    }
}
