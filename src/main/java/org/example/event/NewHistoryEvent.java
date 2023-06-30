package org.example.event;

import javafx.event.Event;
import javafx.event.EventType;

public class NewHistoryEvent extends Event {
    public static final EventType<NewHistoryEvent> NEW_HISTORY_EVENT_TYPE = new EventType<>(Event.ANY, "NewHistoryEvent");
    public NewHistoryEvent() {
        super(NEW_HISTORY_EVENT_TYPE);
    }
}
