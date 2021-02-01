package it.example.websocket.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

  @GetMapping("/webSocketMessageBroker")
  public String webSocketMessageBroker() {
    return "webSocketMessageBroker";
  }

  @GetMapping("/webSocket")
  public String webSocket() {
    return "webSocket";
  }
  
}