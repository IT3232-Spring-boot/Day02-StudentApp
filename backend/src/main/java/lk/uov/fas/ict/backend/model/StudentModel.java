package lk.uov.fas.ict.backend.model;

public class StudentModel {

    private String regNu;
    private String name;
    private int age;
    private String course;

    public StudentModel(String regNu, String name, int age, String course) {
        this.regNu = regNu;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void setRegNu(String regNu) {
        this.regNu = regNu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRegNu() {
        return regNu;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }
}
