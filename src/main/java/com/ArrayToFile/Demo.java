package com.ArrayToFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        TreeSet<Student> studentTreeSet = new TreeSet<>(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student t1, Student t2) {
                        int num = t1.getTotalSocres() - t2.getTotalSocres();
                        num = num == 0 ? t1.getChineseScores() - t2.getChineseScores() : num;
                        num = num == 0 ? t1.getMathScores() - t2.getMathScores() : num;
                        num = num == 0 ? t1.getEngilishScores() - t2.getEngilishScores() : num;
                        num = num == 0 ? t1.getName().compareTo(t2.getName()) : num;
                        return -num;
                    }
                }
        );

        while(studentTreeSet.size() <= 5 ){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Plz input Name, Chinese, Math, English Scores");
            String name = scanner.nextLine();
            System.out.println("input  scores");
            int chinese = scanner.nextInt();
            System.out.println("input  scores");
            int math = scanner.nextInt();
            System.out.println("input  scores");
            int english = scanner.nextInt();
            studentTreeSet.add(new Student(chinese,math,english,name));
        }
        for(var stu : studentTreeSet){
            System.out.println(stu);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("student.txt"));
        for(var stu: studentTreeSet){
            bufferedWriter.write(stu.toString() + " total scores : " + stu.getTotalSocres());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }


}
