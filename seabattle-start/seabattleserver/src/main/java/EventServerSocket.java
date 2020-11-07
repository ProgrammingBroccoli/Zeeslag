import com.google.gson.Gson;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashSet;

@ServerEndpoint(value = "/wstest/")
public class EventServerSocket {
    static HashSet<Session> sessions = new HashSet<>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("[Connected] SessionID:"+session.getId());
        String message = String.format("[New client with client side session ID]: %s", session.getId());
        broadcast(message);
        sessions.add(session);
        System.out.println("[#sessions]: " + sessions.size());
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("[Session ID] : " + session.getId() + " [Received] : " + message);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println("[Session ID] : " + session.getId() + "[Socket Closed: " + reason);
        sessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable cause){
        System.out.println("[Session ID] : " + session.getId() + "[ERROR]: ");
        cause.printStackTrace(System.err);
    }

    public void broadcast(String jsonMessage, Session session) {
        Gson gson = new Gson();

        System.out.println("[Broadcast] { " + jsonMessage + " } to:");

        System.out.println("[End of Broadcast]");
    }
}
