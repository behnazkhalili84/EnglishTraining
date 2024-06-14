package com.example.englishtraining.ui.learningrammar

import com.example.englishtraining.R

object Constants2 {

         val USER_NAME: String = "user_name"
         val TOTAL_WORLD: String = "total_world"

        fun getGrammar(): ArrayList<Grammar> {

            val grammarList = ArrayList<Grammar>()

            // 1
            val letter1 = Grammar(
                1, "A a",
                "Alligator",
                "Apple",
                "Ant",
                R.drawable.aimage,
                R.raw.a
            )
            grammarList.add(letter1)


            // 2
            val letter2 = Grammar(
                2, "B  b",
                "Balloon",
                "Bee",
                "Bear",
                R.drawable.bimage,
                R.raw.b
            )
            grammarList.add(letter2)

            // 3
            val letter3 = Grammar(
                3, "C c",
                "Cat",
                "Carrot",
                "Cow",
                R.drawable.cimage,
                R.raw.c
            )
            grammarList.add(letter3)

            // 4
            val letter4 = Grammar(
                4, "D d",
                "Deer",
                "Donut",
                "Discus throw",
                R.drawable.dimage,
                R.raw.d
            )
            grammarList.add(letter4)

            // 5
            val letter5 = Grammar(
                5, "E e",
                "Elephant",
                "Earth",
                "Eye",
                R.drawable.eimage,
                R.raw.e
            )
            grammarList.add(letter5)

            // 6
            val letter6 = Grammar(
                6, "F f",
                "Fish",
                "Flower",
                "Fence",
                R.drawable.fimage,
                R.raw.f
            )
            grammarList.add(letter6)

            // 7
            val letter7 = Grammar(
                7, "G g",
                "Grapes",
                "Guitar",
                "Gift box",
                R.drawable.gimage1,
                R.raw.g
            )
            grammarList.add(letter3)

            // 8
            val letter8 = Grammar(
                8, "H h",
                "Horse",
                "House",
                "Hamburger",
                R.drawable.himage,
                R.raw.h
            )
            grammarList.add(letter3)

            return grammarList

        }
    }
