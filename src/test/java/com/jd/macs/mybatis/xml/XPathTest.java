package com.jd.macs.mybatis.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

/**
 * Created by machangsheng on 17/8/1.
 */
public class XPathTest {

    @Test
    public void testReadXml() throws Exception {
        DocumentBuilderFactory documentBuilderFactory
                = DocumentBuilderFactory.newInstance();

        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(false);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);

        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

        builder.setErrorHandler(new ErrorHandler() {
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("warning: " + exception.getMessage());
            }

            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error:" + exception.getMessage());
            }

            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("fatalError:" + exception.getMessage());
            }
        });


        Document doc = builder.parse("src/test/resources/inventory.xml");

        XPathFactory  xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        XPathExpression expr = xPath.compile("//book[author='Neal Stephenson']/title/text()");
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("查询作者为Neal Stephenson的图书的标题:");
        NodeList nodes = (NodeList) result;

        for(int i= 0 ; i< nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        //get all book node
        nodes =(NodeList) xPath.evaluate("/inventory/book", doc, XPathConstants.NODESET);

        for(int i=0; i< nodes.getLength(); i++) {
            Node node = nodes.item(i);

            displayNode(node);

//            NamedNodeMap map = node.getAttributes();//属性节点
//            for(int i2=0; i2 < map.getLength(); i2++) {
//                displayNode(map.item(i2));
//            }
//
//            NodeList nodeList = node.getChildNodes();
//            for(int i3=0; i3 < nodeList.getLength(); i3 ++) {
//                displayNode(nodeList.item(i3));
//            }
        }


        System.out.println("查询1997年之后的图书的标题:");
        nodes = (NodeList) xPath.evaluate("//book[@year > 1997]/title/text()",
                doc, XPathConstants.NODESET);
        for(int i= 0 ; i< nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("查询1997年之后的图书的属性和标题:");
        nodes = (NodeList) xPath.evaluate("//book[@year > 1997]/@*|//book[@year > 1997]/title/text()",
                doc, XPathConstants.NODESET);
        for(int i= 0 ; i< nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }


    }


    private void displayNode(Node node ){

        System.out.println(node.getNodeName() + ":" + node.getNodeValue()
                + ":" + node.getNodeType());
    }
}


