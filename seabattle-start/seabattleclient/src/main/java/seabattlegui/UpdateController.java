package seabattlegui;

import communicatorclient.Communicator;
import communicatorclient.CommunicatorClientWebSocket;
import communicatorclient.CommunicatorMessage;

import java.util.Observer;

public class UpdateController {
    public Communicator communicator = null;
    public final String[] properties = {
            "register",
            "ready",
            "fire"
    };

    public UpdateController(){

    }

    public void handle(Object arg){
        CommunicatorMessage message = (CommunicatorMessage)arg;
        String property = message.getProperty();
        String content = message.getContent();

        switch (property){
            default:
            case "register":
                break;
        }

    }

    public void registerPlayer(Observer observer, String playerName){
        communicator = CommunicatorClientWebSocket.getInstance();
        communicator.addObserver(observer);
        communicator.start();

        CommunicatorMessage message = new CommunicatorMessage();
        message.setProperty(properties[0]);
        message.setContent("Player " + playerName + " joined");

        communicator.register(properties[0]);
        communicator.subscribe(properties[0]);
        communicator.update(message);
    }
}
