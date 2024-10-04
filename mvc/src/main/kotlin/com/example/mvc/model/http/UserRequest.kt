package com.example.mvc.model.http

import com.example.mvc.annotation.StringFormatDateTime
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class UserRequest(

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String? = null,

    @field:PositiveOrZero // 0 < 숫자를 검증 0도 포함(양수)
    var age: Int? = null,

    @field:Email // eamil 양식
    var email: String? = null,

    @field:NotBlank// 공백검증
    var address: String? = null,

    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") // 정규식 검증.
    var phoneNumber: String? = null, // phone_number

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt: String? = null // yyyMMdd HH:mm:ss ex) 2020-10-02 13:00:00
) {

}
