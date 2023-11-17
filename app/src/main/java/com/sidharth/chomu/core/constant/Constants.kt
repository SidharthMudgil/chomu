package com.sidharth.chomu.core.constant

import com.sidharth.chomu.R
import com.sidharth.chomu.domain.model.Assistant

object Constants {
    const val BASE_URL = ""
    val ASSISTANTS = listOf(
        Assistant(
            id = 0,
            title = "Compose Emails",
            subtitle = "Effortlessly craft professional and impactful emails.",
            image = R.drawable.img_email,
        ),
        Assistant(
            id = 1,
            title = "Academic Writing",
            subtitle = "Elevate your academic work with precision and style.",
            image = R.drawable.img_writing,
        ),
        Assistant(
            id = 2,
            title = "Summarize Content",
            subtitle = "Generate concise and effective summaries for any text.",
            image = R.drawable.img_summary,
        ),
        Assistant(
            id = 3,
            title = "Grammar Correction",
            subtitle = "Refine your writing with accurate grammar and style checks.",
            image = R.drawable.img_grammar,
        ),
        Assistant(
            id = 4,
            title = "Social Content",
            subtitle = "Create engaging content for social media platforms",
            image = R.drawable.img_social,
        ),
        Assistant(
            id = 5,
            title = "Interview Preparation",
            subtitle = "Confidently prepare for interviews with tailored assistance.",
            image = R.drawable.img_interview,
        ),
    )
}
