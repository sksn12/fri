package com.project.fri.chatting.dto;

import lombok.Data;

@Data
public class CreateChattingMessageRequest {
  private Long roomId;
  private String message;
}
