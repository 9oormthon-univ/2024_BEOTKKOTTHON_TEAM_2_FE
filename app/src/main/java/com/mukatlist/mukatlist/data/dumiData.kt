package com.mukatlist.mukatlist.data

import com.mukatlist.mukatlist.utils.remoteDB

class AllUniData{
    lateinit var l : List<UniData>
    fun allData(): List<UniData> {
        remoteDB().getUniversity()
        return l
    }
    // 클래스 내부에 인스턴스를 생성하는 함수 정의
    fun create(name: List<UniData>) {
        l = name
    }

}