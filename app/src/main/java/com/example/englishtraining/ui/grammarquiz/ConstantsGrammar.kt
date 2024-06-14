package com.example.englishtraining.ui.grammarquiz

import com.example.englishtraining.R

object ConstantsGrammar {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<GrammarQuestion> {
        val questionsList = ArrayList<GrammarQuestion>()

        // 1
        val que1 = GrammarQuestion(
            1, "What is this?",
            R.drawable.apple,
            "D", "B",
            "C", "A", 4
        )

        questionsList.add(que1)

        // 2
        val que2 = GrammarQuestion(
            2, "What is this?",
            R.drawable.water,
            "C", "B",
            "A", "D", 2
        )

        questionsList.add(que2)

        // 3
        val que3 = GrammarQuestion(
            3, "What is this?",
            R.drawable.juice,
            "B", "A",
            "C", "D", 3
        )

        questionsList.add(que3)

        // 4
        val que4 = GrammarQuestion(
            4, "What is this?",
            R.drawable.drink,
            "B", "A",
            "C", "D", 4
        )

        questionsList.add(que4)

        // 5
        val que5 = GrammarQuestion(
            5, "What is this?",
            R.drawable.toes,
            "D", "E",
            "C", "A", 2
        )

        questionsList.add(que5)

        // 6
        val que6 = GrammarQuestion(
            6, "What is this?",
            R.drawable.nose,
            "E", "F",
            "C", "D", 2
        )

        questionsList.add(que6)

        // 7
        val que7 = GrammarQuestion(
            7, "What is this?",
            R.drawable.mouth,
            "F", "B",
            "G", "E", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = GrammarQuestion(
            8, "What is this?",
            R.drawable.chair,
            "F", "H",
            "G", "E", 2
        )

        questionsList.add(que8)


        return questionsList
    }
    // END
}
// END