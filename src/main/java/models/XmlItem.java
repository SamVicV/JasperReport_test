package models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class XmlItem {

    @Path("INSTANCE")
    @Element(name = "name", required = false)
    private String name;

    @Path("INSTANCE")
    @Element(name = "number", required = false)
    private String number;

    @Path("INSTANCE")
    @Element(name = "quantity", required = false)
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
