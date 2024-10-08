package com.example.todo.model.http

import jakarta.validation.Validation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class TodoDtoTest {

    val validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun todoDtoTest(){

        val todoDto = TodoDto().apply {
            this.title ="테스트"
            this.description = ""
            this.schedule = "2020-01-01 15:00:00"
        }

        val result = validator.validate(todoDto)
        result.forEach{
            println(it.propertyPath.last().name)
            println(it.message)
            println(it.invalidValue)
        }
        Assertions.assertEquals(true , result.isEmpty())
    }

}