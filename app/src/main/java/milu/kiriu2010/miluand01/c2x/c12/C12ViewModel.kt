package milu.kiriu2010.miluand01.c2x.c12

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.entity.team0.Team0BaseBall
import milu.kiriu2010.entity.team0.Team0Soccer

class C12ViewModel: ViewModel() {
    val teams: MutableLiveData<MutableList<Team0Abs>> by lazy {
        MutableLiveData<MutableList<Team0Abs>>()
    }

    // チーム一覧を生成
    private fun createData(): MutableList<Team0Abs> {
        val teamLst = mutableListOf<Team0Abs>()

        // チーム一覧:野球
        val teamBaseBalls = Team0BaseBall.createLst()
        teamLst += teamBaseBalls

        // チーム一覧:サッカー
        val teamSoccers = Team0Soccer.createLst()
        teamLst += teamSoccers

        return teamLst
    }

    init {
        teams.value = createData()
    }
}
