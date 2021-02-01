# spring-websocket
Demo project for WebSocket with Spring

## WebSocketMessageBroker solution
To test open in you browser this URL to initialize a WebSocket:

http://localhost:8080/webSocketMessageBroker

Then you can send messages on the WebSocket using the following URL passing the generated SessionId and the message:

http://localhost:8080/notify/${SESSION_ID}?message=${MESSAGE}

for example: http://localhost:8080/notify/42p7lc90?message=hello

## WebSocket solution

To test open in you browser this URL to initialize a WebSocket:

http://localhost:8080/webSocket

- Click Open to initialize a new WebSocket
- Click Sent to send a message on WebSocket
