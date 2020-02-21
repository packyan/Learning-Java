package com.ArrayToFile;

import java.util.Objects;

public class Student {
    private int ChineseScores;
    private int MathScores;
    private  int EngilishScores;
    private String name;

    public Student(int chineseScores, int mathScores, int engilishScores, String name) {
        ChineseScores = chineseScores;
        MathScores = mathScores;
        EngilishScores = engilishScores;
        this.name = name;
    }

    public Student() {
    }

    public int getChineseScores() {
        return ChineseScores;
    }

    public void setChineseScores(int chineseScores) {
        ChineseScores = chineseScores;
    }

    public int getMathScores() {
        return MathScores;
    }

    public void setMathScores(int mathScores) {
        MathScores = mathScores;
    }

    public int getEngilishScores() {
        return EngilishScores;
    }

    public void setEngilishScores(int engilishScores) {
        EngilishScores = engilishScores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getTotalSocres(){
        return getChineseScores()+getEngilishScores()+getMathScores();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ChineseScores == student.ChineseScores &&
                MathScores == student.MathScores &&
                EngilishScores == student.EngilishScores &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ChineseScores, MathScores, EngilishScores, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ChineseScores=" + ChineseScores +
                ", MathScores=" + MathScores +
                ", EngilishScores=" + EngilishScores +
                ", name='" + name + '\'' +
                '}';
    }
}
