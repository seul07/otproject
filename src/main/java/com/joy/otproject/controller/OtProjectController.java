package com.joy.otproject.controller;

import com.joy.otproject.entity.Room;
import com.joy.otproject.service.OtService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/mem/page/{userId}")
    public String memPage(@PathVariable String userId, Model model){
        model.addAttribute("userId",userId);
        return "room/detail";
    }

    @GetMapping("/mem/floor/{userId}/{type}")
    public String memFloor(@PathVariable String userId,@PathVariable String type, Model model){
        Room room = new Room();
        room.setRoom_type(type);
        return "room/detail";
    }
}
