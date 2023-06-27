package org.example.event;

import javafx.event.Event;
import javafx.event.EventType;
import org.example.pojo.History;

public class HistoryLoadEvent extends Event{
    public static final EventType<HistoryLoadEvent> HISTORY_LOAD_EVENT_TYPE = new EventType<>(Event.ANY, "HistoryLoadEvent");

    private History history;
    public HistoryLoadEvent(History history) {
        super(HISTORY_LOAD_EVENT_TYPE);
        this.history = history;
    }
    public History getHistory() {
        return history;
    }
}
