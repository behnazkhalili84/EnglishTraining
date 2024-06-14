package com.example.englishtraining.ui.learningrammar

import com.example.englishtraining.R
import com.example.englishtraining.ui.learningvocabulary.Vocabulary

class Constnts2 {

         val USER_NAME: String = "user_name"
         val TOTAL_WORLD: String = "total_world"

        fun getGramer(): ArrayList<Grammer> {
            val grammerList = ArrayList<Grammer>()

            // 1
            val letter1 = Grammer(
                1, "A a",
                "Alligator",
                "Apple",
                "Ant",
                R.drawable.aimage,
                R.raw.a
            )
            grammerList.add(letter1)


            // 2
            val letter2 = Grammer(
                2, "B  b",
                "Balloon",
                "Bee",
                "Bear",
                R.drawable.bimage,
                R.raw.b
            )
            grammerList.add(letter2)

            // 3
            val letter3 = Grammer(
                3, "C c",
                "Cat",
                "Carrot",
                "Cow",
                R.drawable.cimage,
                R.raw.c
            )
            grammerList.add(letter3)

            // 4
            val letter4 = Grammer(
                4, "D d",
                "Deer",
                "Donut",
                "Discus throw",
                R.drawable.dimage,
                R.raw.d
            )
            grammerList.add(letter4)

            // 5
            val letter5 = Grammer(
                5, "E e",
                "Elephant",
                "Earth",
                "Eye",
                R.drawable.eimage,
                R.raw.e
            )
            grammerList.add(letter5)

            // 6
            val letter6 = Grammer(
                6, "F f",
                "Fish",
                "Flower",
                "Fence",
                R.drawable.fimage,
                R.raw.f
            )
            grammerList.add(letter6)

            // 7
            val letter7 = Grammer(
                7, "G g",
                "Grapes",
                "Guitar",
                "Gift box",
                R.drawable.gimage1,
                R.raw.g
            )
            grammerList.add(letter3)

            // 8
            val letter8 = Grammer(
                8, "H h",
                "Cat",
                "Carrot",
                "Cow",
                R.drawable.himage,
                R.raw.h
            )
            grammerList.add(letter3)

            return grammerList

        }
    }
