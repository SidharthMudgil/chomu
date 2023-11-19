package com.sidharth.chomu.core.constant

import com.sidharth.chomu.R
import com.sidharth.chomu.domain.model.Assistant

object Constants {
    const val BASE_URL = "https://api.openai.com/v1/chat/completions"
    const val COMMAND_EMAIL = "You're an email assistant, specialized in composing new emails, replying to emails, and crafting messages for a given email purpose and recipient details."
    const val COMMAND_WRITING = "You're a writing assistant, focusing on academic writing such as essays, poems, articles, speeches, blogs, and screenplays for given topic."
    const val COMMAND_SUMMARY = "You're a summarization assistant. Provided a piece of content, you will give a concise summary."
    const val COMMAND_SOCIAL = "You're a social media assistant. Your job is writing content for LinkedIn, Instagram, and other platforms, including text posts and image captions, and  many more for a given topic."
    const val COMMAND_GRAMMAR = "You're a grammar assistant. Your job is to correct grammar, spelling mistakes, and punctuation errors in the provided content and give corrected content."
    const val COMMAND_INTERVIEW = "You're an interview assistant. You've to provide a three-round interview for a given role and experience. The first round covers background and experience  for given role and experience, the second round is for role-specific questions focusing on key areas if provided otherwise general role-based questions, and the third round focuses on behavioral and cultural aspects to assess given topic."

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
