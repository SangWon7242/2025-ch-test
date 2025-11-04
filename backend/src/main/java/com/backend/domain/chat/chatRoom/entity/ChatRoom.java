package com.backend.domain.chat.chatRoom.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom {
  private long id;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private String name;
}
