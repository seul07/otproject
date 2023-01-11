package com.joy.hpptproject.controller;

import com.joy.hpptproject.entity.Room;
import com.joy.hpptproject.entity.User;
import com.joy.hpptproject.service.HpptProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HpptProjectController {

    private final HpptProjectService hpptProjectService;

    public HpptProjectController(
            HpptProjectService hpptProjectService
    ) {
        this.hpptProjectService = hpptProjectService;
    }

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("data","hello");
        return "main";
    }

    @GetMapping("/user/{userId}")
    @ResponseBody
    public String userFind(@PathVariable String userId, Model model){
        User user = hpptProjectService.findUser(userId);
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
        List<Integer> floors = hpptProjectService.findFloor(userId,type);
        return floors;
    }

    @GetMapping("/user/room/{userId}/{type}/{floor}")
    @ResponseBody
    public List<Room> userRooms(@PathVariable String userId,@PathVariable String type,
                                   @PathVariable String floor,
                                   Model model){
        List<Room> rooms = hpptProjectService.findRooms(userId,type,floor);
        return rooms;
    }

    @GetMapping("/user/room/update/{userId}/{id}/{newOccupy}")
    @ResponseBody
    public String updateRoom(@PathVariable String userId,@PathVariable String id,
                                @PathVariable String newOccupy,
                                Model model){
        String result = "success";
        try {
            hpptProjectService.updateRoom(userId,id,newOccupy);
        }catch (Exception e){
            result="fail";
        }
        return result;
    }
}
