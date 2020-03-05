package com.knoldus;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Address {
    String primaryAddress;
    Optional<String> secondaryAddress;

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Optional<String> getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(Optional<String> secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }

    public Address(String primaryAddress, String secondaryAddress) {
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = Optional.ofNullable(secondaryAddress);
    }

    public Address(String primaryAddress) {
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = Optional.empty();
    }

}

class Student {
    int studentId;
    String name;
    int age;
    Address address;

    public Student(int studentId, String name, int age, Address address) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

class StudentListModifier {


    public List<Student> stuWithNoSecAddFinder(List<Student> listOfStudents) {

        List<Student> stuWithNoSecAdd = listOfStudents.stream()
                .filter(student -> !student.address.secondaryAddress.isPresent())
                .collect(Collectors.toList());

        return stuWithNoSecAdd;

    }

    public List<Student> sutWithNoSecAddFirstKFinder(List<Student> listOfStudents) {
        List<Student> sutWithNoSecAddFirstK = listOfStudents.stream()
                .filter(student -> !student.address.getSecondaryAddress().isPresent() && student.name.startsWith("K"))
                .collect(Collectors.toList());

        return sutWithNoSecAddFirstK;


    }


}

public class StudentListExtractor {
    public static void main(String[] args) {


        StudentListModifier operation = new StudentListModifier();

        List<Student> listOfStudents = Arrays.asList(new Student(1, "Muskan", 20, new Address("Delhi")),
                new Student(2, "Khivani", 20, new Address("Delhi", "Delhi")),
                new Student(3, "Abhinav", 28, new Address("Agra")),
                new Student(4, "Krishna", 20, new Address("Varanasi")));

         System.out.println(operation.stuWithNoSecAddFinder(listOfStudents));
        System.out.println(operation.sutWithNoSecAddFirstKFinder(listOfStudents));

    }


}