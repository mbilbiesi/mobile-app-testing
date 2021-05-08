package com.hs.mobile.core.logger;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

@Slf4j
public class LoggerWebSocket extends WebSocketClient {
  @Getter private List<String> messagesList = new ArrayList<>();

  public LoggerWebSocket(URI serverUri) {
    super(serverUri);
  }

  @Override
  public void onOpen(ServerHandshake serverHandshake) {
    log.debug("WebSocket is opened to collect phone logs");
  }

  @Override
  public void onMessage(String message) {
    messagesList.add(message);
  }

  @Override
  public void onClose(int code, String reason, boolean remote) {
    log.debug("Connection closed, log streaming has stopped");
  }

  @Override
  public void onError(Exception ex) {
    log.debug("Error in WebSocket: " + ex);
  }

  public void resetMessageList() {
    messagesList.clear();
  }
}
