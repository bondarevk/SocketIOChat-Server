package tk.ld773;


import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import tk.ld773.events.EventMessage;

public class WServer {

    public static void main(String[] args) throws InterruptedException {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(25572);

        final SocketIOServer socketIOServer = new SocketIOServer(config);
        socketIOServer.addEventListener("whoop", EventMessage.class, new DataListener<EventMessage>() {
            @Override
            public void onData(SocketIOClient client, EventMessage data, AckRequest ackSender) throws Exception {
                client.sendEvent("message", new EventMessage("Hello!"));
            }
        });

        socketIOServer.start();
        Thread.sleep(Integer.MAX_VALUE);

        socketIOServer.stop();
    }

}
