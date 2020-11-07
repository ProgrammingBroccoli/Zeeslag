import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import javax.websocket.server.ServerContainer;

public class EventServer {

    private static final int PORT = 8096;

    public static void main(String[] args){
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(PORT);
        server.addConnector(connector);

        //Setting up handler tree
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        try{
            //Init Java.webscoket layer
            ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);

            //Add websocket endpoint to javax.websocket layer
            wscontainer.addEndpoint(EventServerSocket.class);

            server.start();
            System.out.println("HET WERKT");
            server.join();
        } catch (Throwable t){
            t.printStackTrace(System.err);
        }
    }
}
