package com.tushar.nestedrecyclerview.domains

sealed class ViewDomain {
    class HorizontalView(val list:ArrayList<Int>):ViewDomain()
    class VerticalView(val name:String):ViewDomain()
    class PopularView(val list:ArrayList<Int>):ViewDomain()
    class FullListVerticalView(val list:ArrayList<Int>):ViewDomain()

}