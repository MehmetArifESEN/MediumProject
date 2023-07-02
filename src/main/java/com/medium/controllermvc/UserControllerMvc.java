package com.medium.controllermvc;

import com.medium.dto.request.UserLoginRequestDto;
import com.medium.dto.request.UserRegisterRequestDto;
import com.medium.dto.response.UserLoginResponseDto;
import com.medium.repository.entity.User;
import com.medium.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControllerMvc {
    private final UserService userService;
    private final PostControllerMvc postControllerMvc;
    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterRequestDto dto){
        String error = "";
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        try {
            user = userService.save(dto);
            modelAndView.addObject("email",dto.getEmail());
            modelAndView.setViewName("login");
        }catch (Exception ex) {
            error=ex.getMessage();
            modelAndView.setViewName("register");
            modelAndView.addObject("error",error);
        }
        return modelAndView;

    }
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(UserLoginRequestDto dto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            UserLoginResponseDto responseDto=userService.login(dto);
            return  postControllerMvc.getMediumPage(responseDto);

        }catch (Exception ex) {
            modelAndView.addObject("result",ex.getMessage());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
