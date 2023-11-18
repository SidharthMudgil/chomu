package com.sidharth.chomu.domain.model

data class Prompt(
    val model: String,
    val messages: List<Message>
)

data class Message(
    val role: String,
    val content: String
)