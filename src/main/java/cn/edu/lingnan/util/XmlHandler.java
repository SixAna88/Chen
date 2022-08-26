

package cn.edu.lingnan.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

//Ctrl+ alt + b 查看源代码

//事件处理器
public class XmlHandler extends DefaultHandler {

    StringBuffer stringBuffer = new StringBuffer();
    Map<String, String> map = new HashMap<String, String>();

    public Map<String, String> getMap() {
        return map;
    }

    /**
     * Receive notification of the start of an element.
     *
     * <p>By default, do nothing.  Application writers may override this
     * method in a subclass to take specific actions at the start of
     * each element (such as allocating a new tree node or writing
     * output to a file).</p>
     *
     * @param uri        The Namespace URI, or the empty string if the
     *                   element has no Namespace URI or if Namespace
     *                   processing is not being performed.
     * @param localName  The local name (without prefix), or the
     *                   empty string if Namespace processing is not being
     *                   performed.
     * @param qName      The qualified name (with prefix), or the
     *                   empty string if qualified names are not available.
     * @param attributes The attributes attached to the element.  If
     *                   there are no attributes, it shall be an empty
     *                   Attributes object.
     * @throws SAXException Any SAX exception, possibly
     *                                  wrapping another exception.
     * @see org.xml.sax.ContentHandler#startElement
     */

    //元素开始 , 初始化
    //清空字符串
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
            throws SAXException {
        stringBuffer.delete(0, stringBuffer.length());
        // no op
    }

    /**
     * Receive notification of the end of an element.
     *
     * <p>By default, do nothing.  Application writers may override this
     * method in a subclass to take specific actions at the end of
     * each element (such as finalising a tree node or writing
     * output to a file).</p>
     *
     * @param uri       The Namespace URI, or the empty string if the
     *                  element has no Namespace URI or if Namespace
     *                  processing is not being performed.
     * @param localName The local name (without prefix), or the
     *                  empty string if Namespace processing is not being
     *                  performed.
     * @param qName     The qualified name (with prefix), or the
     *                  empty string if qualified names are not available.
     * @throws SAXException Any SAX exception, possibly
     *                                  wrapping another exception.
     * @see org.xml.sax.ContentHandler#endElement
     */

    //把元素名和内容以键值对的形式存入HashMap对象
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        map.put(qName.toLowerCase(), stringBuffer.toString());
        // no op
    }

    /**
     * Receive notification of character data inside an element.
     *
     * <p>By default, do nothing.  Application writers may override this
     * method to take specific actions for each chunk of character data
     * (such as adding the data to a node or buffer, or printing it to
     * a file).</p>
     *
     * @param ch     The characters.
     * @param start  The start position in the character array.
     * @param length The number of characters to use from the
     *               character array.
     * @throws SAXException Any SAX exception, possibly
     *                                  wrapping another exception.
     * @see org.xml.sax.ContentHandler#characters
     */

    //自动调用的方法，传过来的参数是有内容的
    //我们要做的就是把读到的文本内容记录下来
    public void characters(char ch[], int start, int length)
            throws SAXException {
        stringBuffer.append(ch, start, length);
        // no op
    }
}