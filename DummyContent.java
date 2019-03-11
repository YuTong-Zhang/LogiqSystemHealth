package com.example.ultrasound.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    private static final ArrayList<DummyItem> items = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<>();


    public DummyContent(){
    }

    public void addItem(String id, String details){
        DummyItem item = new DummyItem(id, details);
        items.add(item);
    }

    public ArrayList<DummyItem> getList(){
        return items;
    }

    /**
     * A dummy item representing a piece of content.
     */
    public class DummyItem {
        public final String id;
        public final String details;

        public DummyItem(String id, String details) {
            this.id = id;
            this.details = details;
        }

    }
}
