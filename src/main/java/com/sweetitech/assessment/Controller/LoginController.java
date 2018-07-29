package com.sweetitech.assessment.Controller;

import com.sweetitech.assessment.Domain.User;
import com.sweetitech.assessment.Repository.UserRepository;
import com.sweetitech.assessment.Utils.AuthUtils;
import com.sweetitech.assessment.Validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.sweetitech.assessment.Utils.AuthUtils.isLoggedIn;


@Controller
public class LoginController {

    @Autowired
    LoginValidator loginValidator;

    @Autowired
    UserRepository userRepository;

    @InitBinder("user")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(loginValidator);
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,HttpServletRequest request) {
        if (isLoggedIn(request)) {

            return "redirect/home";
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user,
                        BindingResult result,
                        Model model,
                        HttpServletRequest request) {

        if (isLoggedIn(request)) {

            return "redirect:home";
        }

        if (result.hasErrors()) {
            model.addAttribute("loginFailed", true);
            return "login";
        }

        AuthUtils.setAuthIdInSession(request, user);

        return "redirect:home";

    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }

}
