package tk.ld773.events;


public class EventMessage {

    public int id;
    public String text;
    public String sender;

    EventMessage() {

    }

    public EventMessage(String message) {
        super();
        this.id = 0;
        this.text = message;
        this.sender = "Server";
    }

}
