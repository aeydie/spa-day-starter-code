package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("user")
@Controller
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
    return "user/add";
    }


    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user,
                                     Errors errors, String verify){
//        model.addAttribute("username", user.getUsername());
//                model.addAttribute("email", user.getEmail());
//        model.addAttribute("user", user)
        if (errors.hasErrors()) {
            model.addAttribute("Error", "Errors exist!");
            return ("/add");
        }

        if (user.getPassword().equals(user.getVerify())) {
            return "user/index";
        } else {
            model.addAttribute("error", "Sorry passwords don't match! ");
            return "user/add";
        }
    }

}
