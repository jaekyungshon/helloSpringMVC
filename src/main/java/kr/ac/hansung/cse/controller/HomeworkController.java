package kr.ac.hansung.cse.controller;

/* homework controller : 학사 정보 시스템 */

import kr.ac.hansung.cse.model.HomeworkCourses;
import kr.ac.hansung.cse.model.HomeworkRegist;
import kr.ac.hansung.cse.model.HomeworkTotalCredit;
import kr.ac.hansung.cse.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    // 메뉴1 : 학년별 이수 학점 조회 - 학기별 이수 총 학점
    @GetMapping("/menuone")
    public String showMenuOne(Model model) {
        // 학년별 이수 총 학점을 담는 클래스를 한 원소로 갖는 List 가져오기
        List<HomeworkTotalCredit> result = homeworkService.getAllTotalCredit();
        // model에 담기
        model.addAttribute("id_totalcredit",result); // key:id_totalcredit, value:result
        System.out.println("##### showMenuOne Controller");
        return "menuone"; // menuone.jsp
    }

    // 메뉴1의 상세보기 : 학년별 이수 학점 조회 - 학기별 수강 내역
    @GetMapping("/menuonedetails")
    public String showMenuOneDetails(@RequestParam(value="year") int year,
                                     @RequestParam(value="semester") int semester,
                                     Model model){
        // 해당 학기별 레코드 가져오기
        List<HomeworkCourses> result = homeworkService.getYearSemesterHistory(year,semester);
        // model에 담기
        model.addAttribute("id_details",result);
        return "menuonedetails"; // menuonedetails.jsp
    }

    // 메뉴2 : 수강 신청 웹폼
    @GetMapping("/menutwo")
    public String showMenuTwo(Model model){
        // model 설정: 초기 HomeworkRegist 객체.
        model.addAttribute("homeworkRegist",new HomeworkRegist());
        return "menutwo"; // menutwo.jsp
    }

    // 메뉴2 : 수강 신청 웹폼 - request 처리.
    @PostMapping("/domenutwo")
    public String doMenutwo(Model model, @Valid HomeworkRegist homeworkRegist, BindingResult result) {
        if(result.hasErrors()){
            //System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

//            for(ObjectError error : errors){
//                System.out.println(error.getDefaultMessage());
//            }

            return "menutwo"; // form 유효성 검사 결과 실패이기에 form을 다시 받는 menutwo.jsp로 이동.
        }

        homeworkService.insert(homeworkRegist); // DB 저장
        return "menutwocreated"; // menutwocreated.jsp
    }

    // 메뉴3 : 수강 신청 조회
    @GetMapping("/menuthree")
    public String showMenuThree(Model model){
        // 수강신청 테이블 전체 레코드 가져오기
        List<HomeworkRegist> result = homeworkService.getAllRegistration();
        // 모델 속성 추가
        model.addAttribute("id_regist", result);
        return "menuthree"; // menuthree.jsp
    }
}
