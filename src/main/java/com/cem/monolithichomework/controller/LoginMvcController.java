package com.cem.monolithichomework.controller;


import com.cem.monolithichomework.dto.request.LoginRequestDto;
import com.cem.monolithichomework.dto.request.UserSaveRequestDto;
import com.cem.monolithichomework.exception.ErrorType;
import com.cem.monolithichomework.exception.MonolithicHomeworkManagerException;
import com.cem.monolithichomework.repository.entity.EGender;
import com.cem.monolithichomework.repository.entity.User;
import com.cem.monolithichomework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginMvcController {

    private final UserService userService;

    // localhost:9092/login/registerpage
    @GetMapping("/registerpage")
    public ModelAndView register(){
        // return new ModelAndView("register");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("genders", EGender.values());
        modelAndView.setViewName("register");
        return modelAndView;
    }
//    @PostMapping("/doregister")
//    public ModelAndView doRegister(String name, String surname,String username, String email, String password, String gender){
//        userService.save(
//                User.builder()
//                        .name(name)
//                        .surname(surname)
//                        .username(username)
//                        .email(email)
//                        .password(password)
//                        .gender(EGender.valueOf(gender))
//                        .build()
//        );
//        return new ModelAndView("redirect:loginpage");
//    }

    @PostMapping("/doregister")
    public ModelAndView doRegister(UserSaveRequestDto dto){
        userService.saveRequestDto(dto);
        return new ModelAndView("redirect:loginpage");
    }

    @GetMapping("/loginpage")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;

    }

    @PostMapping("/dologin")
    public ModelAndView doLogin(LoginRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> user = userService.login(dto.getUsername(), dto.getPassword());

        if (user.isPresent()){
            modelAndView.addObject("user", userService.findById(user.get().getId()).get());
            // System.out.println(userService.findById(user.get().getId()).get().getGender());
            modelAndView.setViewName("home");
        }

        else{
            modelAndView.setViewName("login");
            throw new MonolithicHomeworkManagerException(ErrorType.USER_NOT_FOUND);
        }
        return modelAndView;
    }

}
