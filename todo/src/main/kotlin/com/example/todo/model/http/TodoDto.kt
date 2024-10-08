package com.example.todo.model.http

import com.example.todo.annotation.StringFormatDateTime
import com.example.todo.database.Todo
import jakarta.validation.constraints.NotBlank
import org.springframework.context.annotation.Description
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class TodoDto(
        var index: Int? = null,

        @field:NotBlank
        var title: String? = null,

        var description: String? = null,

        @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
        var schedule: String? = null,

        var createdAt: LocalDateTime? = null,

        var updatedAt: LocalDateTime? = null,
)
fun TodoDto.convertTodoDto(todo: Todo): TodoDto {
        return TodoDto().apply {
                this.index = todo.index
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                this.createdAt = todo.createdAt
                this.updatedAt = todo.updatedAt
        }
}
