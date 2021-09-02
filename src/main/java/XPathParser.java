import models.RootXml;
import models.RootXmlItem;
import models.XmlItem;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;

public class XPathParser {
    private final String nameExpr = "./name";
    private final String numberExpr = "./number";
    private final String qntExpr = "./quantity";

    public RootXml parseFile(String fileName){
        RootXml list = new RootXml();

        try {
            FileInputStream fileIS = new FileInputStream(fileName);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//INSTANCE";
            XPathExpression expr = xPath.compile(expression);
            NodeList nodeList = (NodeList) expr.evaluate(xmlDocument, XPathConstants.NODESET);
            Node firstNode = null;
            RootXmlItem rItem = null;
            for (int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (node.getParentNode().getNodeName().equalsIgnoreCase("WTObject") &&
                        (firstNode == null || !firstNode.isEqualNode(node.getParentNode()))){
                    firstNode = node.getParentNode();
                    rItem = new RootXmlItem();
                    rItem.setName(xPath.evaluate(nameExpr, node));
                    rItem.setNumber(xPath.evaluate(numberExpr, node));
                    list.addRootItem(rItem);
                } else {
                    if (rItem != null) {
                        XmlItem item = new XmlItem();
                        item.setName(xPath.evaluate(nameExpr, node));
                        item.setNumber(xPath.evaluate(numberExpr, node));
                        item.setQuantity(Integer.parseInt(xPath.evaluate(qntExpr, node)));
                        rItem.addItem(item);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
