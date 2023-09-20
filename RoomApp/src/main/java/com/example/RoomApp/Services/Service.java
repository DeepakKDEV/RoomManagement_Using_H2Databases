package com.example.RoomApp.Services;

import com.example.RoomApp.Model.RoomApp;
import com.example.RoomApp.Repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
  @Autowired
  RoomRepo roomRepo;

  public String addRoom(RoomApp newRoom) {
    roomRepo.save(newRoom);
    return "Add h2 post data";
  }


  public List<RoomApp> getAll() {

    //  return (List<RoomApp>) roomRepo.findAll();
    return (List<RoomApp>) roomRepo.findAll();
  }


  public  String update(Integer id, Integer roomNumber) {
    RoomApp roomUpdate = roomRepo.findById(id).orElse(null);
    if (roomUpdate != null) {
      roomUpdate.setRoomNumber(roomNumber);
      roomRepo.save(roomUpdate);
      return "Room updated successfully";
      }

    return "Room not found";
    }
  public String DeleteNumber(Integer id) {
    Optional<RoomApp> roomToDelete = roomRepo.findById(id);
    if (roomToDelete.isPresent()) {
      roomRepo.deleteById(id);
      return "Room with ID " + id + " deleted successfully";
    } else {
      return "Room with ID " + id + " not found";
      }
  }
}
