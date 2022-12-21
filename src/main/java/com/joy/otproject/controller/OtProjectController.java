package com.joy.otproject.controller;

import com.joy.otproject.entity.Room;
import com.joy.otproject.entity.User;
import com.joy.otproject.service.OtService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OtProjectController {

    private final OtService otService;

    public OtProjectController(
            OtService otService
    ) {
        this.otService = otService;
    }

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("data","hello");
        return "main";
    }

    @GetMapping("/user/{userId}")
    @ResponseBody
    public String userFind(@PathVariable String userId, Model model){
        User user = otService.findUser(userId);
        String message="FAIL";
        if(user!=null){
            message="SUCCESS";
        }
        return message;
    }

    @GetMapping("/user/page/{userId}")
    public String userPage(@PathVariable String userId, Model model){
        model.addAttribute("userId",userId);
        return "room/detail";
    }

    @GetMapping("/user/floor/{userId}/{type}")
    @ResponseBody
    public List<Integer> userFloor(@PathVariable String userId,@PathVariable String type, Model model){
        List<Integer> floors = otService.findFloor(userId,type);
        return floors;
    }

    @GetMapping("/user/room/{userId}/{type}/{floor}")
    @ResponseBody
    public List<Room> userRooms(@PathVariable String userId,@PathVariable String type,
                                   @PathVariable String floor,
                                   Model model){
        List<Room> rooms = otService.findRooms(userId,type,floor);
        return rooms;
    }

    @GetMapping("/user/room/update/{userId}/{id}/{newOccupy}")
    @ResponseBody
    public String updateRoom(@PathVariable String userId,@PathVariable String id,
                                @PathVariable String newOccupy,
                                Model model){
        String result = "success";
        try {
            otService.updateRoom(userId,id,newOccupy);
        }catch (Exception e){
            result="fail";
        }
        return result;
    }
}
