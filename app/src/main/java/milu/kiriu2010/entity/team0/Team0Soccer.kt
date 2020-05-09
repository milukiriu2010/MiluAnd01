package milu.kiriu2010.entity.team0

import milu.kiriu2010.miluand01.R

// ------------------------------------------
// サッカーチームのクラス
// ------------------------------------------
data class Team0Soccer(
    override var type: String = "",
    override var name: String = "",
    override var playerLst: List<String> = mutableListOf(),
    override var yearPosMap: Map<Int, Int> = mutableMapOf(),
    override var logo: Int = R.drawable.ic_main,
    var level: Int = -1
) : Team0Abs {
    companion object {
        // ------------------------------------------
        // サッカーチームのリストを生成
        // ------------------------------------------
        fun createLst(): MutableList<Team0Abs> {
            var frontale = Team0Soccer( "soccer", "frontale", mutableListOf("damiano" ,"kobayashi"), mutableMapOf(2017 to  1, 2018 to 1, 2019 to  4), R.drawable.ic_soccer_frontale, 1)
            var antlers  = Team0Soccer( "soccer", "antlers" , mutableListOf("everaldo","ito"      ), mutableMapOf(2017 to  2, 2018 to 3, 2019 to  3), R.drawable.ic_soccer_antlers , 1)
            var cerezo   = Team0Soccer( "soccer", "cerezo"  , mutableListOf("kakiya"  ,"tokura"   ), mutableMapOf(2017 to  3, 2018 to 7, 2019 to  5), R.drawable.ic_soccer_cerezo  , 1)
            var verdy    = Team0Soccer( "soccer", "verdy"   , mutableListOf("leandro" ,"okubo"    ), mutableMapOf(2017 to  5, 2018 to 6, 2019 to 13), R.drawable.ic_soccer_verdy   , 2)
            var zelvia   = Team0Soccer( "soccer", "zelvia"  , mutableListOf("masovic" ,"stefan"   ), mutableMapOf(2017 to 16, 2018 to 4, 2019 to 18), R.drawable.ic_soccer_zelvia  , 2)

            return mutableListOf(frontale,antlers,cerezo,verdy,zelvia)
        }
    }
}
