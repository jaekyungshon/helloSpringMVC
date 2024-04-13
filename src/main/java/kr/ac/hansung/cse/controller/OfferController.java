package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
