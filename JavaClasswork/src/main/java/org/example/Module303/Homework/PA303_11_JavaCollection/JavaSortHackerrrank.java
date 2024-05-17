package org.example.Module303.Homework.PA303_11_JavaCollection;

import java.util.*;

class JavaSortHackerrank2 {

    private int id;
    private String fname;
    private double cgpa;

    public JavaSortHackerrank2(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class JavaSortHackerrrank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<JavaSortHackerrank2> studentList = new ArrayList<JavaSortHackerrank2>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            JavaSortHackerrank2 st = new JavaSortHackerrank2(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList, new Comparator<JavaSortHackerrank2>() {
            @Override
            public int compare(JavaSortHackerrank2 s1, JavaSortHackerrank2 s2) {
                if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                } else if (!s1.getFname().equals(s2.getFname())) {
                    return s1.getFname().compareTo(s2.getFname());
                } else {
                    return Integer.compare(s1.getId(), s2.getId());
                }
            }
        });

        for (JavaSortHackerrank2 st : studentList) {
            System.out.println(st.getFname());
        }

        in.close();
    }
}
