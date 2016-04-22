package com.dtcj.liukai.simplestock.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 随机指数
 * 当日K值 = 1/3当日RSV + 2/3前1日K值 ;
 * 当日D值 = 2/3前1日D值 + 1/3当日K值;
 * 当日J值 = 3当日K值 - 2当日D值.
 * Author: liuk
 * Created at: 16/4/22
 */
public class KDJEntity {

    private ArrayList<Double> Ks = new ArrayList<>();
    private ArrayList<Double> Ds = new ArrayList<>();
    private ArrayList<Double> Js = new ArrayList<>();

    public KDJEntity(List<OHLCEntity> OHLCData) {

        ArrayList<Double> ks = new ArrayList<>();
        ArrayList<Double> ds = new ArrayList<>();
        ArrayList<Double> js = new ArrayList<>();

        double k = 0.0;
        double d = 0.0;
        double j = 0.0;
        double rSV = 0.0;

        if (OHLCData != null && OHLCData.size() > 0) {
            OHLCEntity ohlcEntity = OHLCData.get(OHLCData.size() - 1);
            double high = ohlcEntity.getHigh();
            double low = ohlcEntity.getLow();

            for (int i = OHLCData.size() - 1; i >= 0; i--) {
                if (i < OHLCData.size() - 1) {
                    ohlcEntity = OHLCData.get(i);
                    high = high > ohlcEntity.getHigh() ? high : ohlcEntity.getHigh();
                    low = low < ohlcEntity.getLow() ? low : ohlcEntity.getLow();
                }
                if (high != low) {
                    rSV = (ohlcEntity.getClose() - low) / (high - low) * 100;
                }
                if (i == OHLCData.size() - 1) {
                    k = rSV;
                    d = k;
                } else {
                    k = k * 2 / 3 + rSV / 3;    //当日K值 = 1/3当日RSV + 2/3前1日K值
                    d = d * 2 / 3 + k / 3;      //当日D值 = 2/3前1日D值 + 1/3当日K值
                }
                j = 3 * k - 2 * d;      //当日J值 = 3当日K值 - 2当日D值

                ks.add(k);
                ds.add(d);
                js.add(j);
            }

            for (int i = ks.size() - 1; i >= 0; i--) {
                Ks.add(ks.get(i));
                Ds.add(ds.get(i));
                Js.add(js.get(i));
            }
        }
    }

    public ArrayList<Double> getK() {
        return Ks;
    }

    public ArrayList<Double> getD() {
        return Ds;
    }

    public ArrayList<Double> getJ() {
        return Js;
    }
}
