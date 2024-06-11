package com.example.englishtraining.ui.vocabularyquiz

import com.example.englishtraining.R

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<VocabularyQuestion> {
        val questionsList = ArrayList<VocabularyQuestion>()

        // 1
        val que1 = VocabularyQuestion(
            1, "What is this?",
            R.drawable.apple,
            "drink", "water",
            "apple", "nose", 3
        )

        questionsList.add(que1)

        // 2
        val que2 = VocabularyQuestion(
            2, "What is this?",
            R.drawable.water,
            "juice", "water",
            "apple", "nose", 2
        )

        questionsList.add(que2)

        // 3
        val que3 = VocabularyQuestion(
            3, "What is this?",
            R.drawable.juice,
            "juice", "water",
            "apple", "nose", 1
        )

        questionsList.add(que3)

        // 4
        val que4 = VocabularyQuestion(
            4, "What is this?",
            R.drawable.drink,
            "juice", "water",
            "drink", "nose", 3
        )

        questionsList.add(que4)

        // 5
        val que5 = VocabularyQuestion(
            5, "What is this?",
            R.drawable.toes,
            "Toes", "water",
            "drink", "nose", 1
        )

        questionsList.add(que5)

        // 6
        val que6 = VocabularyQuestion(
            6, "What is this?",
            R.drawable.nose,
            "Noes", "Toes",
            "water", "drink", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = VocabularyQuestion(
            7, "What is this?",
            R.drawable.mouth,
            "Noes", "Toes",
            "Mouth", "drink", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = VocabularyQuestion(
            8, "What country does this flag belong to?",
            R.drawable.chair,
            "Noes", "Toes",
            "Mouth", "Chair", 4
        )

        questionsList.add(que8)


        return questionsList
    }
    // END
}
// END