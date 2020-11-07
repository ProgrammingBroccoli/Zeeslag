module seabattleclient {
  requires slf4j.api;
  requires javafx.graphics;
  requires javafx.controls;
    requires javafx.base;
  requires javax.websocket.client.api;

  exports seabattlegui;
}