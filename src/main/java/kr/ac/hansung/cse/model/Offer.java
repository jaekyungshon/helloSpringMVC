package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Offer {
    private int id; // db에서 auto_increment 설정했기에, set안해도됨.

    //@Size(min, max, message) : 유효성 검사 길이
    @Size(min=2, max=100, message="Name must be between 2 and 100 chars")
    private String name;

    @Email(message="Please provide a valid email address") // 유효성 검사 : 이메일
    @NotEmpty(message="The email address cannot be empty") // 유효성 검사 : 공백 불가
    private String email;

    @Size(min=5, max=100, message = "Text must be between 5 and 100 chars")
    private String text;
}
