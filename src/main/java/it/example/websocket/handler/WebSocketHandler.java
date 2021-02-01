package it.example.websocket.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
	
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
       
    	super.handleTextMessage(session, message);

        session.sendMessage(new TextMessage("Hello " + message.getPayload()));
        
    }
    
}
