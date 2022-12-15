package com.joy.otproject.controller;

import com.joy.otproject.entity.Room;
import com.joy.otproject.service.OtService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OtProjectController {

    private final OtService otService;

    public OtProjectController(
            @Qualifier("otService") OtService otService
    ) {
        this.otService = otService;
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("data","hello");
        return "main";
    }

    @GetMapping("/user/page/{userId}")
    public String memPage(@PathVariable String userId, Model model){
        model.addAttribute("userId",userId);
        return "room/detail";
    }

    @GetMapping("/user/floor/{userId}/{type}")
    public String memFloor(@PathVariable String userId,@PathVariable String type, Model model){
        List<Integer> floors = otService.findFloor(userId,type);
        return "room/detail";
    }
}
