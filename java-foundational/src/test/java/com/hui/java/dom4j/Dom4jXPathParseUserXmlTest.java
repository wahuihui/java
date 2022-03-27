package com.hui.java.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * dom4j结合XPath解析user.xml
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/26 18:28
 * @since JDK8
 */

public class Dom4jXPathParseUserXmlTest {

    public static void main(String[] args) {

        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read(Dom4jXPathParseUserXmlTest.
                    class.getClassLoader().getResource("user.xml"));
            //第一个用户的密码
            System.out.println("1.------>使用绝对路径方式查找元素");
            Element passwordElement = (Element) document.selectSingleNode("/users/user/password");
            String password = passwordElement.getText();
            System.out.println("第一个用户的密码是："+password);

            System.out.println("2.------>使用相对路径方式查找元素");
            Node node = passwordElement.selectSingleNode("../salary");
            String salary = node.getText();
            System.out.println("第一个用户的薪水区间是："+salary);

            System.out.println("3.------>使用全文搜索的方式");
            System.out.println("获取所有ID元素的文本");
            List<Node> idNodeList = document.selectNodes("//id");
            for (Node idNode : idNodeList) {
                String idTest = idNode.getText();
                System.out.println(idTest);
            }

            System.out.println("4.------>谓语(条件筛选)方式");
            System.out.println("获取user id 属性为TB10002的用户信息");
            Node TB10002Node = document.selectSingleNode("//user[@id='TB10002']");
            Element TB10002Element = (Element) TB10002Node;
            List<Element> elementList = TB10002Element.elements();
            for (Element element : elementList) {
                System.out.println("user子标签的名字："+element.getName());
                System.out.println("user子标签的文本："+element.getTextTrim());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}


















