module seabattleclient {
  requires slf4j.api;
  requires javafx.graphics;
  requires javafx.controls;
    requires javafx.base;

    exports seabattlegui;
}