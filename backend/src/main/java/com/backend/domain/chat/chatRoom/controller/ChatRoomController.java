package com.backend.domain.chat.chatRoom.controller;

import com.backend.domain.chat.chatRoom.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody
@RequestMapping("/api/v1/chat/rooms")
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

  @GetMapping("/{id}")
  public ChatRoom getChatRoom(@PathVariable long id) {
    Optional<ChatRoom> opChatRoom = findBy(id);

    if(opChatRoom.isEmpty()) {
      throw new RuntimeException("%d번 데이터는 없습니다.".formatted(id));
    }

    return opChatRoom.get();
  }

  private Optional<ChatRoom> findBy(long id) {
    return chatRooms.stream()
        .filter(chatRoom -> chatRoom.getId() == id)
        .findFirst();
  }
}
