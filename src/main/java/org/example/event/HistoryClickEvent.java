package org.example.event;

import javafx.event.Event;
import javafx.event.EventType;
import org.example.pojo.History;

public class HistoryClickEvent extends Event {
    public static final EventType<HistoryClickEvent> HISTORY_CLICK_EVENT_TYPE = new EventType<>(Event.ANY, "HistoryClickEvent");
    public HistoryClickEvent() {
        super(HISTORY_CLICK_EVENT_TYPE);
    }
}
