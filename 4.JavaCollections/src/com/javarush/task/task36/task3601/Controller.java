package com.javarush.task.task36.task3601;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.List;

/**
 * Created by work on 21.02.2017.
 */
public class Controller {
    private View view;
    private Model model = new Model();
    public List<String> onDataListShow() {
        return model.getStringDataList();
    }
}
