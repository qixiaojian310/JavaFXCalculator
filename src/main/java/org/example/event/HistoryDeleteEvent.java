package org.example.event;

import javafx.event.Event;
import javafx.event.EventType;
import org.example.pojo.History;

public class HistoryDeleteEvent extends Event {
    public static final EventType<HistoryDeleteEvent> HISTORY_DELETE_EVENT_TYPE = new EventType<>(Event.ANY, "HistoryDeleteEvent");
    private History history;
    public HistoryDeleteEvent(History history) {
        super(HISTORY_DELETE_EVENT_TYPE);
        this.history = history;
    }

    public History getHistory() {
        return history;
    }
}
