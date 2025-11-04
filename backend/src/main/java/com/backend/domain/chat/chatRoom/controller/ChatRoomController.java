package com.backend.domain.chat.chatRoom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody
@RequestMapping("/api/v1/chat/room")
public class ChatRoomController {
  @GetMapping
  public List<String> getChatRooms() {
    return List.of(
        "room1",
        "room2",
        "room3"
    );
  }
}
