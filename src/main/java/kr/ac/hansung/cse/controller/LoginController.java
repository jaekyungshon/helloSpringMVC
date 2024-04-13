package kr.ac.hansung.cse.controller;

/* ch05 : Custom login form controller */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin(@RequestParam(value="error", required = false) String error,
                            @RequestParam(value="logout", required = false) String logout,
                            Model model) {

        if(error!=null){
            model.addAttribute("errorMsg", "Invalid username or password");
        }
        if(logout!=null){
            model.addAttribute("logoutMsg", "You hava been logged out successfully");
        }
        return "login"; // login.jsp
    }
}
