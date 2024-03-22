package com.mukatlist.mukatlist.data

import com.mukatlist.mukatlist.R
import com.mukatlist.mukatlist.ui.theme.CALENDAR
import com.mukatlist.mukatlist.ui.theme.GROUPMUKATLIST
import com.mukatlist.mukatlist.ui.theme.MUKATLIST
import com.mukatlist.mukatlist.ui.theme.MYPAGE
import com.mukatlist.mukatlist.ui.theme.SEARCHMUSTEAT

sealed class BottomNavItems(
    val name: Int,
    val route: String,
    val icon: Int,
    val icon_selected: Int
){
    object Mukatlist: BottomNavItems(R.string.text_mukatlist, MUKATLIST, R.drawable.ic_mukatlist_grey, R.drawable.ic_mukatlist_orange)
    object SearchMusteat: BottomNavItems(R.string.text_searchmusteat, SEARCHMUSTEAT, R.drawable.ic_searchmusteat_grey, R.drawable.ic_searchmusteat_orange)
    object Calendar: BottomNavItems(R.string.text_calendar, CALENDAR, R.drawable.ic_calendar_grey, R.drawable.ic_calendar_orange)
    object MyPage: BottomNavItems(R.string.text_mypage, MYPAGE, R.drawable.ic_mypage_grey, R.drawable.ic_mypage_orange)

}

sealed class TopNavItem(
    //val university: String = isNull(userData.user.getUniversity_data()),
    val route: String
){
//    fun getUniversity(): String {
//        return university
//    }

    //isNull(userData.user.getUniversity_data()) ,
    object Top: TopNavItem(MUKATLIST)
}

sealed class Top_MypageNavItem(
    val route: String
){
    object Top: Top_MypageNavItem(MUKATLIST)
}


fun isNull(string: String?): String{
    if(string == null)
        return "null"
    else
        return string
}