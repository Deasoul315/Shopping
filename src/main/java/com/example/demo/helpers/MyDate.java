package com.example.demo.helpers;

public class MyDate {
    Integer day;
    Integer year;
    Integer month;

    public MyDate(Integer day, Integer year, Integer month) {
        this.day = day;
        this.year = year;
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
