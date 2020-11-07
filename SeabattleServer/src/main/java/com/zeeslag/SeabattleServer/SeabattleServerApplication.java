package SeabattleServer.src.main.java.com.zeeslag.SeabattleServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@SpringBootApplication
@ServerEndpoint(value = "/sockets")
public class SeabattleServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeabattleServerApplication.class, args);
	}

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
