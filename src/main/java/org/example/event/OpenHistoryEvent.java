package org.example.event;

import javafx.event.Event;
import javafx.event.EventType;

public class OpenHistoryEvent extends Event {
    public static final EventType<OpenHistoryEvent> OPEN_HISTORY_EVENT_TYPE = new EventType<>(Event.ANY, "OpenHistoryEvent");
    public OpenHistoryEvent() {
        super(OPEN_HISTORY_EVENT_TYPE);
    }
}
