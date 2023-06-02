package by.it_academy.jd2.Mk_JD2_98_23.core.dto;


public class MessageCreateDTO {
    private UserDTO from;
    private UserDTO to;
    private String text;

    public MessageCreateDTO(UserDTO from, UserDTO to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
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
