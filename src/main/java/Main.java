import models.RootXml;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Started");

        long ld1 = System.currentTimeMillis();
        RootXml xmlFile1 = new XPathParser().parseFile("Exercise1.xml");
        long ld2 = System.currentTimeMillis();
        System.out.println("XPath time: " + (ld2 - ld1));


        ld1 = System.currentTimeMillis();
        Serializer serializer = new Persister();
        File source = new File("Exercise1.xml");
        RootXml xmlFile = null;
        try {
            xmlFile = serializer.read(RootXml.class, source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ld2 = System.currentTimeMillis();
        System.out.println("Framework: " + (ld2 - ld1));
        System.out.println("\n");
        if (xmlFile != null && xmlFile.getInstances() != null && xmlFile.getInstances().size() > 0){
            new ReportBuilder().build(xmlFile.getInstances().get(0).getUses());
            System.out.println("\n");
        }
        System.out.println("Finished");

    }
}
