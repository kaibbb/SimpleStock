package com.dtcj.liukai.simplestock.entity;

import java.util.List;

/**
 * Author: liuk
 * Created at: 16/4/22
 */
public class MALineEntity {

    private List<Float> lineData;   //线表示数据
    private String title;   //线的标题
    private int lineColor;  //线表示颜色

    public MALineEntity() {
        super();
    }

    public MALineEntity(List<Float> lineData, String title, int lineColor) {
        this.lineData = lineData;
        this.title = title;
        this.lineColor = lineColor;
    }

    public List<Float> getLineData() {
        return lineData;
    }

    public void setLineData(List<Float> lineData) {
        this.lineData = lineData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

}
