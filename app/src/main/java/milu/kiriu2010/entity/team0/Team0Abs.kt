package milu.kiriu2010.entity.team0

// --------------------------------------
// チームのインターフェース
// --------------------------------------
// kotlinのdataクラスは継承ができないので
// インターフェースにしている
// --------------------------------------
// https://blog.applibot.co.jp/2018/03/22/inheritance-for-dataclass-kotlin/
// --------------------------------------
interface Team0Abs {
    var type: String
    var name: String
    var playerLst: List<String>
    var yearPosMap: Map<Int,Int>
    var logo: Int
}
