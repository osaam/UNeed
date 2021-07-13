package com.osamaelsh3rawy.graduation.data.model

import com.osamaelsh3rawy.graduation.R
import java.util.*

object constant{

    fun getItems():ArrayList<Items> {

        val allItems= ArrayList<Items>()

        val item3=Items(3,"speaker",25550,"electronics", R.drawable.speaker,"very good speaker",false)
        val item4=Items(4,"charger",50,"electronics", R.drawable.charger,"very good charger",false)
        val item7=Items(7,"body",1550,"clothes",R.drawable.shirt2,"very good body",false)
        val item8=Items(8,"sweatshirt",1550,"clothes",R.drawable.shirt3,"very good sweatshirt",false)
        val item9=Items(9,"rice",1550,"supermarket", R.drawable.rise,"very good product",false)
        val item10=Items(10,"apple",1550,"supermarket", R.drawable.apple,"very good product",false)
        val item11=Items(11,"spagiti",1550,"supermarket", R.drawable.spagiti,"very good product",false)
        val item12=Items(12,"bottle",1550,"supermarket", R.drawable.bottel,"very good product",false)
        val item13=Items(13,"mi 10 ultra",1550,"mobiles", R.drawable.iphone,"very good product",false)
        val item5=Items(5,"t-shirt",1550,"clothes", R.drawable.shirt,"very good t-shirt",false)
        val item6=Items(6,"trawser",1550,"clothes", R.drawable.shirt,"very good trawser",false)

      val item14=Items(14,"oppo",1550,"mobiles", R.drawable.iphone,"very good product",false)
        val item15=Items(15,"samsung note 12",1550,"mobiles", R.drawable.iphone,"very good product",false)
        val item16=Items(16,"iphone 12",1550,"mobiles",
            R.drawable.iphone,"very good iphone 12",false)

        allItems.add(item3)
        allItems.add(item4)
        allItems.add(item5)
        allItems.add(item6)
        allItems.add(item7)
        allItems.add(item8)
        allItems.add(item9)
        allItems.add(item10)
        allItems.add(item11)
        allItems.add(item12)
        allItems.add(item13)
        allItems.add(item14)
        allItems.add(item15)
        allItems.add(item16)

        return allItems
    }
    fun getelectronics():ArrayList<Items> {

        val allItems= ArrayList<Items>()
        val item17=Items(2,"samsung laptop",12000,"electronics", R.drawable.apple,"very good laptop",false)
        val item18=Items(14,"oppo",1550,"mobiles", R.drawable.speaker2,"very good product",false)
        val item19=Items(15,"samsung note 12",1550,"mobiles", R.drawable.watch,"very good product",false)
        val item20=Items(16,"iphone 12",1550,"mobiles",R.drawable.iphone,"very good iphone 12",false)

        val item3=Items(3,"speaker",25550,"electronics", R.drawable.speaker,"very good speaker",false)
        val item4=Items(4,"charger",50,"electronics", R.drawable.charger,"very good charger",false)
        val item13=Items(13,"mi 10 ultra",1550,"mobiles", R.drawable.iphone,"very good product",false)
        val item2=Items(2,"samsung laptop",12000,"electronics", R.drawable.laptop,"very good laptop",false)
    val item14=Items(14,"oppo",1550,"mobiles", R.drawable.iphone,"very good product",false)
        val item15=Items(15,"samsung note 12",1550,"mobiles", R.drawable.iphone,"very good product",false)
        val item16=Items(16,"iphone 12",1550,"mobiles",R.drawable.iphone,"very good iphone 12",false)


        allItems.add(item13)
        allItems.add(item14)
        allItems.add(item3)
        allItems.add(item4)
        allItems.add(item2)
        allItems.add(item15)
        allItems.add(item16)
        allItems.add(item17)
        allItems.add(item18)
        allItems.add(item19)
        allItems.add(item20)

        return allItems
    }
    fun getclothes():ArrayList<Items> {

        val allItems= ArrayList<Items>()

        val item6=Items(6,"trawser",1550,"clothes", R.drawable.shirt2,"very good trawser",false)
        val item7=Items(7,"body",1550,"clothes",R.drawable.shirt,"very good body",false)
        val item5=Items(5,"shirt",1550,"clothes", R.drawable.shirt3,"very good t-shirt",false)
        val item9=Items(7,"body",1550,"clothes",R.drawable.shirt,"very good body",false)
        val item10=Items(5,"shirt",1550,"clothes", R.drawable.swatshirt,"very good t-shirt",false)

        val item8=Items(8,"sweatshirt",1550,"clothes",R.drawable.shirt4,"very good sweatshirt",false)

        allItems.add(item5)
        allItems.add(item6)
        allItems.add(item7)
        allItems.add(item8)
        allItems.add(item9)
        allItems.add(item10)

        return allItems
    }
    fun getmarket():ArrayList<Items> {

        val allItems= ArrayList<Items>()

         val item2=Items(2,"samsung laptop",12000,"electronics", R.drawable.laptop,"very good laptop",false)
        val item3=Items(3,"speaker",25550,"electronics", R.drawable.speaker,"very good speaker",false)
        val item4=Items(4,"charger",50,"electronics", R.drawable.charger,"very good charger",false)
        val item5=Items(5,"t-shirt",1550,"clothes", R.drawable.shirt,"very good t-shirt",false)
        val item6=Items(6,"trawser",1550,"clothes", R.drawable.shirt4,"very good trawser",false)
        val item7=Items(7,"body",1550,"clothes",R.drawable.shirt3,"very good body",false)
        val item8=Items(8,"sweatshirt",1550,"clothes",R.drawable.shirt2,"very good sweatshirt",false)
        val item9=Items(9,"rice",1550,"supermarket", R.drawable.rise,"very good product",false)
        val item10=Items(10,"apple",1550,"supermarket", R.drawable.apple,"very good product",false)
        val item11=Items(11,"spagiti",1550,"supermarket", R.drawable.spagiti,"very good product",false)
        val item12=Items(12,"bottle",1550,"supermarket", R.drawable.bottel,"very good product",false)
        val item13=Items(13,"huawi",1550,"mobiles", R.drawable.huawi,"very good product",false)
        val item14=Items(14,"i phone 13",1550,"mobiles", R.drawable.iphone111,"very good product",false)
        val item15=Items(15," iphone 11",1550,"mobiles", R.drawable.iphone2,"very good product",false)
        val item16=Items(16,"iphone 12",1550,"mobiles",
            R.drawable.iphone,"very good iphone 12",false)


        val item18=Items(10,"oil",1550,"supermarket", R.drawable.apple,"very good product",false)

        allItems.add(item2)
        allItems.add(item3)
        allItems.add(item4)
        allItems.add(item5)
        allItems.add(item6)
        allItems.add(item7)
        allItems.add(item8)
        allItems.add(item9)
        allItems.add(item10)
        allItems.add(item11)
        allItems.add(item12)
        allItems.add(item13)
        allItems.add(item14)
        allItems.add(item15)
        allItems.add(item16)
        allItems.add(item18)
        return allItems
    }
}