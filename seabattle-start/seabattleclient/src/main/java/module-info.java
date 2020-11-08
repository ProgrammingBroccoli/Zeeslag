module seabattleclient {
  requires slf4j.api;
  requires javafx.graphics;
  requires javafx.controls;
  requires javafx.base;
  requires java.sql;
  requires communicatorclient;
  requires gson;

  exports seabattlegui;
}