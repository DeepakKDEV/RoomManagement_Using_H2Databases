package com.example.RoomApp.Controller;

import com.example.RoomApp.Model.RoomApp;
import com.example.RoomApp.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired

    Service   roomService;
    @PostMapping("room")
    public  String addRoom(@RequestBody RoomApp   newRoom){
         return roomService.addRoom(newRoom);
    }

//    public String addRooms(@RequestBody RoomApp newRooms){
//        return roomService.addrooms(newRooms);
//    }

    @GetMapping("rooms")
    public List<RoomApp> getAll(){
        return roomService.getAll();
    }
    @PutMapping("update/id/{id}")
    public String update(@PathVariable Integer id, @RequestParam Integer roomNumber){
         return roomService.update(id,roomNumber);
    }
   @DeleteMapping("delete/{id}")
    public String DeleteNumber(@PathVariable Integer id){
        return roomService.DeleteNumber(id);
    }

}
