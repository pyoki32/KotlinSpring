package com.example.todo.controller.api.todo

import com.example.todo.model.http.TodoDto
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@Tag(name = "Test", description = "Test 관련 API입니다.")
@RestController
@RequestMapping("/api/todo")
class TodoApiController {

    //R

    @GetMapping(path = [""])
    fun read(@RequestParam(required = false) index: Int?) {

    }

    //C
    @PostMapping(path = [""])
    fun create(@Valid @RequestBody todoDto: TodoDto) {

    }

    //U
    @PutMapping(path = [""])
    fun update(@Valid @RequestBody todoDto: TodoDto) {

    }

    //D
    @DeleteMapping(path = ["/{index}"])
    fun delete(@PathVariable(name ="index") _index: Int?) {

    }
}