import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/socket")
public class Controller {

    private Session session;

    @OnOpen
    public void onOpen(Session session){
        //TODO: Get session and webSocket connection
        this.session = session;
        System.out.println("WebSockets started");
    }

    @OnMessage
    public void onMessage(Session session, String Message){
        //TODO: Handle new Messages
        System.out.println("NewMessage");
    }

    @OnClose
    public void onClode(Session session){
        //TODO: WebSocket connection closes
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        //TODO: Do error handling
    }
}
