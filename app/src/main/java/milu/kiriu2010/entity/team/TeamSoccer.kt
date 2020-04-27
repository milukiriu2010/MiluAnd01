package milu.kiriu2010.entity.team

// ------------------------------------------
// サッカーチームのクラス
// ------------------------------------------
data class TeamSoccer(
    override var type: String = "",
    override var name: String = "",
    override var playerLst: List<String> = mutableListOf(),
    override var yearPosMap: Map<Int, Int> = mutableMapOf(),
    var level: Int = -1
) : TeamAbs {
    companion object {
        // ------------------------------------------
        // サッカーチームのリストを生成
        // ------------------------------------------
        fun createLst(): MutableList<TeamAbs> {
            var frontale = TeamSoccer( "soccer", "frontale", mutableListOf("damiano" ,"kobayashi"), mutableMapOf(2017 to  1, 2018 to 1, 2019 to  4), 1)
            var antlers  = TeamSoccer( "soccer", "antlers" , mutableListOf("everaldo","ito"      ), mutableMapOf(2017 to  2, 2018 to 3, 2019 to  3), 1)
            var cerezo   = TeamSoccer( "soccer", "cerezo"  , mutableListOf("kakiya"  ,"tokura"   ), mutableMapOf(2017 to  3, 2018 to 7, 2019 to  5), 1)
            var verdy    = TeamSoccer( "soccer", "verdy"   , mutableListOf("leandro" ,"okubo"    ), mutableMapOf(2017 to  5, 2018 to 6, 2019 to 13), 2)
            var zelvia   = TeamSoccer( "soccer", "zelvia"  , mutableListOf("masovic" ,"stefan"   ), mutableMapOf(2017 to 16, 2018 to 4, 2019 to 18), 2)

            return mutableListOf(frontale,antlers,cerezo,verdy,zelvia)
        }
    }
}
