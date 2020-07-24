package milu.kiriu2010.entity.team0

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Player(
    // 名
    var fname: String="",
    // 姓
    var lname: String="",
    // 誕生日
    var bday: Date = Calendar.getInstance().time
) : Parcelable