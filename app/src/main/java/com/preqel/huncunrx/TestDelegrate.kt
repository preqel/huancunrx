package com.preqel.huncunrx

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by preqel on 2018/9/22.
 */
class TestDelegrate{

//
//    class ResouceID() {
//        val image_id: String = "101"
//        val text_id: String = "102"
//    }
//
//    class ResouceLoader(id:ResouceID){
//        val d :ResouceID  = id
//        operator fun providerDelegate(thisRef:My)
//    }
//
//    class DellImpl(d: ResouceID) : ReadOnlyProperty {
//        val id: ResouceID = d
//        override fun getValue(thisRef: MyUI, property: KProperty): String {
//            if(property.name.equals("image"))
//                return property.name+"  "+id.image_id
//            else
//                return property.name+"  "+id.text_id
//        }
//    }
//
//    fun  bindResource(id: ResouceID): ResourceLoader {
//        var res = ResourceLoader(id);
//        return res
//    }
//
//    class MyUI {
//        val image by bindResource(ResourceID())
//        val text by bindResource(ResourceID())
//        //val webview by bindResource(ResourceID())
//    }
//


    companion object {


    }
}