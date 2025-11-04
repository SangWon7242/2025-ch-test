package com.backend.domain.chat.chatRoom.controller;

import com.backend.domain.chat.chatRoom.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody
@RequestMapping("/api/v1/chat/room")
public class ChatRoomController {
  private final List<ChatRoom> chatRooms = new ArrayList<>() {{
    add(ChatRoom.builder()
        .id(1)
        .createDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .name("테니스 하실 분")
        .build());

    add(ChatRoom.builder()
        .id(2)
        .createDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .name("테니스 하실 분")
        .build());

    add(ChatRoom.builder()
        .id(3)
        .createDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .name("테니스 하실 분")
        .build());
  }};

  @GetMapping
  public List<ChatRoom> getChatRooms() {
    return chatRooms;
  }
}
