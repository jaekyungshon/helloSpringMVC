package kr.ac.hansung.cse.model;

/* 학기별 이수 총 학점을 담는 자바 클래스 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HomeworkTotalCredit {
    private int year; // 년도
    private int semester; // 학기
    private int totalCredit; // 취득 학점

    // 기본 생성자
    // 매개변수 없는 어노테이션 미사용 이유 : totalCredit 초기값을 주기 위해.
    public HomeworkTotalCredit(){
        this.totalCredit=0;
    }
    public void sumTotalCredit(int credit) {
        this.totalCredit+=credit;
    }
}
