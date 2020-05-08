package com.github.messenger_server.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private String from;
    private String text;
    private String time;
}
