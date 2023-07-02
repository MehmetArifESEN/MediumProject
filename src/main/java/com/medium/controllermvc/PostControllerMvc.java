package com.medium.controllermvc;

import com.medium.dto.response.UserLoginResponseDto;
import com.medium.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostControllerMvc {
    private final PostService postService;
    @GetMapping("")
    public ModelAndView getMediumPage(UserLoginResponseDto responseDto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("medium");
        modelAndView.addObject("userBilgileri", responseDto);
        return modelAndView;
    }
}
