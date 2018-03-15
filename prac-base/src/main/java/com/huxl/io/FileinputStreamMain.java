package com.huxl.io;

import java.io.*;
import java.util.Scanner;

/**
 * @author huxl
 * @createDate 2018/3/14 11:41
 */
public class FileinputStreamMain {
    public static void main(String[] args) throws IOException {
//        testReadFile();
//        testWriteFile();
        writeAndReadTest();

    }

    private static void testReadFile() throws FileNotFoundException,IOException {
        String filePath = "D:/from.txt";
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fin);
        BufferedReader reader = new BufferedReader(isr);
//        System.out.println(reader.read());
        System.out.println(reader.readLine());
        String str = "";
        while ((str = reader.readLine()) != null) {
            if (str.equals("")) {
                continue;
            }
            System.out.print(str);
        }

    }

    private static void testWriteFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("D:/to.txt");
            String name = "Jason";
            double salary = 18000;
            writer.println(name);
            writer.print(" ");
            writer.print(salary);
            writer.write("ssdsdsds");
//            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    //Java核心技术实例 程序清单2-1
    private static void writeAndReadTest(){
        Employee[] staffs = new Employee[3];
        staffs[0] = new Employee("Jason1",22,18000);
        staffs[1] = new Employee("Jason2",22,18000);
        staffs[2] = new Employee("Jason2",22,18000);

        PrintWriter out = null;
        try {
            //写
            out = new PrintWriter("employee.dat","utf-8");
            writeData(staffs,out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        //读
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream("employee.dat"),"utf-8");
            Employee[] employees = readData(in);
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * read按array of employees from a scanner
     * @param in  the scanner
     * @return   the array of employees
     */
    private static Employee[] readData(Scanner in) {
        //确定数组的大小
        int n = 0;
        //移动指针到下一行
        String line = in.nextLine();
        char  c = line.charAt(line.length()-1);
        n = Integer.parseInt(String.valueOf(c));
        System.out.println("这是一行多余信息：" + line);


        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    /**
     * read employee data from bufferd reader
     * @param in the scanner
     * @return
     */
    private static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        double salary = Double.parseDouble(tokens[2]);
        return new Employee(name,age,salary);
    }

    //save all data to file
    private static void writeData(Employee[] staffs, PrintWriter out) throws IOException {

        out.println("员工数量：" + staffs.length);
        for (Employee employee: staffs) {
            writeEmployee(employee,out);
        }
    }

    private static void writeEmployee(Employee employee, PrintWriter out) {
        out.println(employee.getName() + "|" + employee.getAge() + "|" + employee.getSalary());
    }

    private static class Employee{
        private String name;
        private Integer age;
        private double salary;

        public Employee() {
        }

        public Employee(String name, Integer age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}
