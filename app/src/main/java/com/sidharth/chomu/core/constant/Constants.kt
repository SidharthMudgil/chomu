package com.sidharth.chomu.core.constant

import com.sidharth.chomu.domain.model.Assistant

object Constants {
    const val BASE_URL = ""
    val ASSISTANTS = listOf(
        Assistant(
            id = 0,
            title = "Email",
            subtitle = "this is a sample text 1 for email generation",
            image = "",
        ),
        Assistant(
            id = 1,
            title = "Writing",
            subtitle = "this is a sample text 1 for writing assistants",
            image = "",
        ),
        Assistant(
            id = 2,
            title = "Summary",
            subtitle = "this is a sample text 1 for summary generation",
            image = "",
        ),
        Assistant(
            id = 3,
            title = "Grammar",
            subtitle = "this is a sample text 1 for grammar correction",
            image = "",
        ),
        Assistant(
            id = 4,
            title = "Social",
            subtitle = "this is a sample text 1 for creating social posts and contents",
            image = "",
        ),
        Assistant(
            id = 5,
            title = "Interview",
            subtitle = "this is a sample text 1 for preparing for the interview",
            image = "",
        ),
    )
}
