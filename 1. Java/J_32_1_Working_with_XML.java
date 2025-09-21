/*
    XML in Java -
    ___________________________________________________________________________________________

    To handle Extensible Markup Language (XML) file, java have built-in library
        JAXP which is widely used.


    What is DOM?
    --------------------------------
    The Document Object Model (DOM) is defined as a programming interface for web documents.
    In the context of XML processing in Java, DOM represents XML document as a tree model,
        where each node in the tree model corresponds to a part of the document.
    They are used to work with and navigate this tree using methods of the DOM API.

    The Java API for XML Processing (JAXMP) provides a set of interfaces and classes
    for processing XML documents in Java programming. Here are some interfaces and classes.

    - DocumentBuilder: DocumentBuilder is a pre-defined interface in the JAXMP library
        that defines the methods for parsing XML documents and creating a
        DOM (Document Object Model) tree.

    - DocumentBuilderFactory: This class provides a factory for creating
        DocumentBuilder objects. It obtains the document builder instance,
        which is then used to parse XML documents.

    - Document: Document is an interface that offers ways to read and modify the
        content of an XML document while also representing the full document.

    - Element: An XML document's interface that represents an element.
        Elements are the fundamental units of the XML structure.

    - NodeList: An XML document's ordered collection of nodes represented by an
        interface that is usually used to traverse over a list of elements.

    - Transformer: An XML document transformation interface that specifies how to change
        the content of a Source tree into a result tree.

    - Source: An interface that can represent a stream of XML, a DOM tree,
        or other sources as the input for a transformation.

    - StreamResult: a class that shows the output of a straightforward transformation,
        usually as a character or byte stream.

*/


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;


/* 
    The Below code will produce this output file- 

    <?xml version="1.0" encoding="UTF-8" standalone="no"?>
    <library>
        <Program1> Java Programming </Program1>
        <Program2> Python Programming </Program2>
        <Program3> JavaScript </Program3>
        <Program4> C Programming </Program4>
    </library>
*/


public class J_32_1_Working_with_XML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a new Document
        Document document = builder.newDocument();

        // Create root element
        Element root = document.createElement("library");
        document.appendChild(root);

        // Create book elements and add text content
        Element book1 = document.createElement("Program1");
        book1.appendChild(document.createTextNode("Java Programming"));

        Element book2 = document.createElement("Program2");
        book2.appendChild(document.createTextNode("Python Programming"));

        Element book3 = document.createElement("Program3");
        book3.appendChild(document.createTextNode("JavaScript"));

        Element book4 = document.createElement("Program4");
        book4.appendChild(document.createTextNode("C Programming"));

        root.appendChild(book1);
        root.appendChild(book2);
        root.appendChild(book3);
        root.appendChild(book4);

        // Write to XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        // Specify your local file path
        StreamResult result = new StreamResult("C:\\Users\\himan\\Desktop\\test.xml");
        transformer.transform(source, result);

        System.out.println("XML file created successfully!");




        //  To Read the XML File.

        // Specify the file path as a File object
        File xmlFile = new File("C:\\Users\\himan\\Desktop\\test.xml");

        // Create a DocumentBuilder
        DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = factory2.newDocumentBuilder();

        // Parse the XML file
        Document document2 = builder2.parse(xmlFile);



        // Access elements by tag name
        NodeList nodeList2 = document2.getElementsByTagName("library");
        for (int i = 0; i < nodeList2.getLength(); i++) {
            Node node = nodeList2.item(i);
            System.out.println("Element Content: " + node.getTextContent());
        }



    }
}