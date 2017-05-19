package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 17.02.2017.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    @XmlType(name = "goods")
    @XmlRootElement
    public static class Goods{

        public List<String> names;

        public Goods(List<String> names) {
            this.names = names;
        }

        public Goods() {
        }
    }
    public Goods goods;

    public int count;

    public  double profit;

    public String[] secretData = new String[4];
}
