package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NumberingCriteria {
    private String type;
    private int length;
    private String prefix;
    private String suffix;
    @Column(name = "criteria_order")
    private int order;

    public NumberingCriteria(String type, int length, String prefix, String suffix, int order) {
        this.type = type;
        this.length = length;
        this.prefix = prefix;
        this.suffix = suffix;
        this.order = order;
    }

    public NumberingCriteria() {
        type = "";
        length = 0;
        prefix = "";
        suffix = "";
        order = 0;
    }

    // getters and setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    

}