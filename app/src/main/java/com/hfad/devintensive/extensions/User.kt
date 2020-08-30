package com.hfad.devintensive.extensions

import com.hfad.devintensive.models.User
import com.hfad.devintensive.models.UserView
import com.hfad.devintensive.utils.Utils
import com.hfad.devintensive.utils.Utils.transliteration
import java.util.*

fun User.toUserView() : UserView{

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName,lastName)
    val status = if(lastVisit == null) "Еще ни разу не был" else if(isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status
    )
}




