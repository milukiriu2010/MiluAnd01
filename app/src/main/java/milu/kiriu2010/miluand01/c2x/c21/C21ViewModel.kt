package milu.kiriu2010.miluand01.c2x.c21

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.entity.team0.Team0BaseBall
import milu.kiriu2010.entity.team0.Team0Soccer

class C21ViewModel: ViewModel() {
    val teams: MutableList<MutableLiveData<Team0Abs>> = mutableListOf()

    // チーム一覧を生成
    private fun createData() {

        val teamLst = mutableListOf<Team0Abs>()

        // チーム一覧:野球
        val teamBaseBalls = Team0BaseBall.createLst()
        teamLst += teamBaseBalls

        // チーム一覧:サッカー
        val teamSoccers = Team0Soccer.createLst()
        teamLst += teamSoccers

        teams.clear()

        teamLst.forEach { team0Abs ->
            val liveData = MutableLiveData<Team0Abs>()
            liveData.value = team0Abs
            teams.add(liveData)
        }
    }

    init {
        createData()
    }
}
