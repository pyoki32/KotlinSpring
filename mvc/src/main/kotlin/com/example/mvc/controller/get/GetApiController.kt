package com.example.mvc.controller.get;

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController;

@RestController //Rest API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"]) // GET http://localhost:8080/api/hello , GET http://localhost:8080/api/abcd
    fun hello(): String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping// http://localhost:8080/api"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/pyoki
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name}, ${age}")
        return name + " " + age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/pyoki
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age: Int): String {
        val name = "kotlin"
        println("${_name}, ${age}")
        return _name + " " + age
    }

    // https://localhost:8080/api/page?key=value&leu=value
    @GetMapping("/get-mapping/query-param") // ?name=pyoki&age=20
    fun queryParam(
        @RequestParam name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("${name} , ${age}")
        return name + " " + age
    }

    // name, age, address, email
    // -
    // phoneNumber -> phonenumber , phone-number
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest : UserRequest) : UserRequest{
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map : Map<String,Any>) : Map<String,Any>{
        println(map)
        val phoneNumber = map.get("phone-number")
        return map
    }
}
