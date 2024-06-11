package com.example.englishtraining.ui.learningvocabulary

import com.example.englishtraining.R
import com.example.englishtraining.ui.vocabularyquiz.VocabularyQuestion

object Constants1 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_WORLD: String = "total_world"

    fun getVocabulary1(): ArrayList<Vocabulary> {
        val vocabularyList = ArrayList<Vocabulary>()
        // 1
        val world1 = Vocabulary(
            1,"Apple",
            "Apple is a delicious fruit",
            "R.drawable.apple",
            "http://")
         vocabularyList.add(world1)


        // 2
        val world2 = Vocabulary(
            2,
            "Drink",
            "I like sweet drinks",
            "R.drawable.drink",
            "http://")

        vocabularyList.add(world2)

        // 3
        val world3 = Vocabulary(
            3,
            "Water",
            "she is thirsty, she needs water ",
            "R.drawable.apple",
            "http://")

        vocabularyList.add(world3)

        // 4
        val world4 = Vocabulary(
            4,
            "Juice",
            "I drink orange juice",
            "R.drawable.juice",
            "http://")

        vocabularyList.add(world4)

        // 5
        val world5 = Vocabulary(
            5,
            "Toes",
            "My toes hurt",
            "R.drawable.toes",
            "http://")

        vocabularyList.add(world5)

        // 6
        val world6 = Vocabulary(
            6,
            "Nose",
            "A big nose",
            "R.drawable.nose",
            "http://")

        vocabularyList.add(world6)

        // 7
        val world7 = Vocabulary(
            7,
            "Mouth",
            "A beautiful mouth",
            "R.drawable.nose",
            "http://")

        vocabularyList.add(world7)

        // 8
        val world8 = Vocabulary(
            8,"Chair",
            "Sit down on the chair",
            "R.drawable.apple",
            "http://")

        vocabularyList.add(world8)

        return vocabularyList

    }

    fun getVocabulary2(): ArrayList<Vocabulary> {
        val vocabularyList = ArrayList<Vocabulary>()
        // 9
        val world9 = Vocabulary(
            9,
            "Milk",
            "I drink milk every day",
            "R.drawable.milk",
            "http://")

        vocabularyList.add(world9)


        // 10
        val world10 = Vocabulary(
            10,
            "Sweet",
            "don't eat too much sweets",
            "R.drawable.sweets",
            "http://")

        vocabularyList.add(world10)

        // 11
        val world11 = Vocabulary(
            11,
            "Cup",
            "I drink in my cup",
            "R.drawable.cup",
            "http://")

        vocabularyList.add(world11)

        // 12
        val world12 = Vocabulary(
            12,
            "Biscuit",
            "A chocolate biscuit",
            "R.drawable.biscuit",
            "http://")

        vocabularyList.add(world12)

        // 13
        val world13 = Vocabulary(
            13,
            "Mummy and baby",
            "Mummy loves her baby",
            "R.drawable.mambaby",
            "http://")

        vocabularyList.add(world13)

        // 14
        val world14 = Vocabulary(
            14,
            "Plate",
            "Please wash your plate",
            "R.drawable.plate",
            "http://")

        vocabularyList.add(world14)

        // 15
        val world15 = Vocabulary(
            15,
            "Table",
            "I ate at the table",
            "R.drawable.table",
            "http://")

        vocabularyList.add(world15)

        // 16
        val world16 = Vocabulary(
            16,
            "Daddy", "I love my daddy",
            "R.drawable.dady",
            "http://")

        vocabularyList.add(world16)

        return vocabularyList

    }
}