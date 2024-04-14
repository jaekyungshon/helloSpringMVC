package kr.ac.hansung.cse.model;

/* homework(학사정보시스템) : 수강신청 엔티티 클래스 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HomeworkRegist {
    private int id; // 기본키

    @Pattern(regexp="\\d{4}", message="연도는 4자리의 숫자를 입력해주세요.")
    @NotEmpty(message="연도를 입력하지 않았습니다(4자리)")
    private String year; // 연도

    @Pattern(regexp = "[1-2]", message = "학기는 1 또는 2 중에서 선택하세요.")
    @NotEmpty(message = "학기를 입력하지 않았습니다.(1 또는 2)")
    private String semester; // 학기

    @NotEmpty(message = "교과목명을 기입하지 않았습니다.")
    @Size(max=255, message = "교과목명은 최대 255자까지 가능합니다.")
    private String name; // 교과목명

    @Pattern(regexp = "일교|일선|전기|전필|전선|선필교|교필", message="유효하지 않은 교과구분입니다.")
    @NotEmpty(message = "교과구분을 입력하지 않았습니다.")
    private String classification; // 교과구분

    @Size(min=2, max=15, message="2자~15자까지 입력 가능합니다.")
    @NotEmpty(message = "담당교수명을 입력하지 않았습니다.")
    private String professor; // 담당교수

    @Pattern(regexp = "[1-3]", message = "학점은 1~3 중에서 입력해주세요.")
    @NotEmpty(message = "학점을 입력해주세요.")
    private String credit; // 학점
}
