package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OfferController {
    // Controller -> Service -> DAO (DTO: entity==model)
    @Autowired
    private OfferService offerService; // OfferService 타입 bean이 존재하는 경우, 자동매핑.

    @GetMapping("/offers")
    public String showOffers(Model model) { //Spring 에서 제공하는 Model 객체.
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("id_offers",offers); // key: id_orrers, value:offers

        return "offers"; // offers.jsp(View에서 id_offers로 접근.
    }

    // Web Form ch04 실습
    @GetMapping("/createoffer")
    public String createOffer(Model model) {
        /*
        * 첫 createoffer VIew 때는 빈 Offer가 들어옴.
        * 그러나, doCreate 이후, 유효성 검사가 실패해서 다시 이 함수가 호출된다면?
        * => doCreate 처리에서 검사 실패 변수를 제외한 나머지는 모두 엔티티에 저장됨.
        * => 즉, 데이터 버퍼링이 오류 변수 빼고는 제대로 기입된 기존 내용은 form에 남아있게 된다.
        * */
        model.addAttribute("offer",new Offer());
        return "createoffer"; //createoffer.jsp
    }

    // DataBinding, DataValidate 실습 ch04
    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result){ // offer entity에 파람 들어옴.
        // offer는 자동으로 model에 저장됨.
        // @Valid : 데이터 유효성 검사 ch04
        // 유효성 검사 결과를 result에 넣게 된다.(자동)
        // Data Buffering : 유효성 검사 실패시, 다시 넘어가는 페이지의 기입내용을 유지하는 기능.

        //System.out.println(offer);
        if(result.hasErrors()){
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error : errors){
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer"; // form 유효성 검사 결과 실패이기에 form을 다시 받는 View로 이동.
        }

        offerService.insert(offer); // Controller -> Service -> Dao -> 저장
        return "offercreated"; // offercreated.jsp : model에 들어가있는 offer 접근 가능.
    }
}
