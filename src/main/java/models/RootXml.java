package models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "WTObject", strict = false)
public class RootXml {
    @ElementList(name = "WTObject", entry = "INSTANCE", required = false)
    private ArrayList<RootXmlItem> instances;

    public ArrayList<RootXmlItem> getInstances() {
        return instances;
    }

    public void setInstances(ArrayList<RootXmlItem> instances) {
        this.instances = instances;
    }

    public void addRootItem(RootXmlItem item){
        if (instances == null)
            instances = new ArrayList<>();
        instances.add(item);
    }
}
