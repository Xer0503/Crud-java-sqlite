package net.codejava.operations;

public class Student {
    private int id;
    private String name;
    private double gwa;

    public Student(int id, String name, double gwa) {
        this.id = id;
        this.name = name;
        this.gwa = gwa;
    }

    // Optional: getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getGwa() { return gwa; }

    // For printing like Python's __str__
    @Override
    public String toString() {
        return id + " | " + name + " | " + gwa;
    }
}

