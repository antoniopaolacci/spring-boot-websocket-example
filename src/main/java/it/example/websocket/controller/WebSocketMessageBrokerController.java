package it.example.websocket.controller;

import com.example.websocket.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketMessageBrokerController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/register")
    public void processMessageFromClient(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        // logger.info("sessionID" + message);
        System.out.println("sessionID " + message.getSessionId());
    }

    @MessageMapping("/unregister")
    public void unregister(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        System.out.println("sessionID " + message.getSessionId());
    }

    @GetMapping("/notify/{sessionId}")
    public void notiy(@PathVariable("sessionId") String sessionId, @RequestParam("message") String message) {
        messagingTemplate.convertAndSendToUser(sessionId, "/queue/notify", message, createHeaders(sessionId));
    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }
    
}
