package models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;

public class RootXmlItem {
    @Element(name = "name", required = false)
    private String name;
    @Element(name = "number", required = false)
    private String number;

    @ElementList(name = "INSTANCE", entry = "uses", required = false, inline = true)
    private ArrayList<XmlItem> uses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<XmlItem> getUses() {
        return uses;
    }

    public void setUses(ArrayList<XmlItem> uses) {
        this.uses = uses;
    }

    public void addItem(XmlItem item){
        if (uses == null)
            uses = new ArrayList<>();
        uses.add(item);
    }
}
