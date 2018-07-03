/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfexport;

import org.junit.Test;
import static org.junit.Assert.*;
import pdfexport.components.Text;

/**
 *
 * @author pedro
 */
public class XMLConverterTest {
    private final String TEST_TXT =                 "teste";
    private final String TEMPLATE_EXPECTED_XML =    "<template>\n" +
                                                    "  <documentHeader/>\n" +
                                                    "  <pageHeader/>\n" +
                                                    "  <body>\n" +
                                                    "    <pdfexport.components.Text>\n" +
                                                    "      <text>"+TEST_TXT+"</text>\n" +
                                                    "    </pdfexport.components.Text>\n" +
                                                    "  </body>\n" +
                                                    "  <pageFooter/>\n" +
                                                    "  <documentFooter/>\n" +
                                                    "</template>";
    @Test
    public void testSerializeTemplateToXML() {
        Template t = new Template();
        Text text = new Text(TEST_TXT);
        t.body.add(text);
        String result = XMLConverter.serializeTemplateToXML(t);
        assertEquals(TEMPLATE_EXPECTED_XML, result);
    }
    @Test
    public void testDeserializeTemplateFromXML() {
        Template result = XMLConverter.deserializeTemplateFromXML(TEMPLATE_EXPECTED_XML);
        Text expected = new Text(TEST_TXT);
        Text textResult = (Text) result.body.get(0);
        assertEquals(expected.text, textResult.text);
    }
    
}