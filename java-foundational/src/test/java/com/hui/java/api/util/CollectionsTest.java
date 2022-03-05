package com.hui.java.api.util;

import com.hui.java.foundational.interfaces.service.Cellphone;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections类的常用方法测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/5 10:31
 * @since JDK8
 */

public class CollectionsTest {

    List<Integer> list;
    List<Cellphone> cellphoneList;

    @BeforeClass
    public void initList(){
        list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7);
    }


}



















