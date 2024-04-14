package kr.ac.hansung.cse.model;

/* Courses 테이블 Entity 클래스 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HomeworkCourses {
    private int id; // 기본키(레코드 구분용)
    private int year; // 년도
    private int semester; // 학기
    private String code; // 교과코드
    private String name; // 교과목명
    private String classification; // 교과구분
    private String professor; // 담당교수
    private int credit; // 학점
}
