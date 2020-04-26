package milu.kiriu2010.entity.team

// ------------------------------------------
// 野球チームのクラス
// ------------------------------------------
data class TeamBaseBall(
    override var type: String = "",
    override var name: String = "",
    override var playerLst: List<String> = mutableListOf(),
    override var yearPosMap: Map<Int, Int> = mutableMapOf(),
    var league: LeagueBaseBall = LeagueBaseBall.UNKNOWN
): TeamAbs

// ------------------------------------------
// 野球チームのリストを生成
// ------------------------------------------
class TeamBaseBallLst{
    companion object {
        fun createLst(): List<TeamBaseBall> {
            var tigers   = TeamBaseBall("baseball", "Tigers"  , mutableListOf("nishi"   , "takahashi")  , mutableMapOf(2017 to 2, 2018 to 6, 2019 to 3), LeagueBaseBall.CENTRAL )
            var giants   = TeamBaseBall("baseball", "giants"  , mutableListOf("sugano"  ,"takahashi")   , mutableMapOf(2017 to 4, 2018 to 3, 2019 to 1), LeagueBaseBall.CENTRAL )
            var carp     = TeamBaseBall("baseball", "carp"    , mutableListOf("osera"   ,"nomura")      , mutableMapOf(2017 to 1, 2018 to 1, 2019 to 4), LeagueBaseBall.CENTRAL )
            var baystars = TeamBaseBall("baseball", "baystars", mutableListOf("imanaga" ,"hamaguchi")   , mutableMapOf(2017 to 3, 2018 to 4, 2019 to 2), LeagueBaseBall.CENTRAL )
            var swallows = TeamBaseBall("baseball", "swallows", mutableListOf("ishikawa","ogawa")       , mutableMapOf(2017 to 6, 2018 to 2, 2019 to 6), LeagueBaseBall.CENTRAL )
            var dragons  = TeamBaseBall("baseball", "dragons" , mutableListOf("ohno"    ,"yanagi")      , mutableMapOf(2017 to 5, 2018 to 5, 2019 to 5), LeagueBaseBall.CENTRAL )

            return mutableListOf<TeamBaseBall>(tigers,giants,carp,baystars,swallows,dragons)
        }
    }
}
