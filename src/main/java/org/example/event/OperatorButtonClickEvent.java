package org.example.event;

import javafx.event.Event;
import javafx.event.EventType;

public class OperatorButtonClickEvent extends Event {
    public static final EventType<OperatorButtonClickEvent> OPERATOR_BUTTON_CLICK_EVENT_TYPE = new EventType<>(Event.ANY, "OperatorButtonClickEvent");

    public OperatorButtonClickEvent() {
        super(OPERATOR_BUTTON_CLICK_EVENT_TYPE);
    }
}
