package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/")
public class RoomController {

    private final RoomService roomServices;


    @Autowired
    public RoomController(RoomService roomService) {
        this.roomServices = roomService;
    }

    @GetMapping(value = "rooms")
    public String getRooms(Model model){
        Set<Room> allRoom = roomServices.getAllRoom();
        model.addAttribute("allRoom", allRoom);
        return "rooms";
    }

    @PostMapping(value = "rooms")
    public String createEmptyRoom(){
        roomServices.addNewRoom();
        return "redirect:";
    }

    @GetMapping(value = "rooms/{roomId}")
    public String getRoomById(Model model, @PathVariable String roomId){
        Room myRoom = roomServices.findRoomById(roomId);
        model.addAttribute("myRoom", myRoom);
        return "rooms";
    }
}
