package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import java.time.LocalDateTime;

public class MessageDTO {
    private int id;
    private LocalDateTime dateTime;
    private UserDTO from;
    private UserDTO to;
    private String text;

    public MessageDTO() {
    }

    public MessageDTO(int id, LocalDateTime dateTime, UserDTO from, UserDTO to, String text) {
        this.id = id;
        this.dateTime = dateTime;
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UserDTO getFrom() {
        return from;
    }

    public void setFrom(UserDTO from) {
        this.from = from;
    }

    public UserDTO getTo() {
        return to;
    }

    public void setTo(UserDTO to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}