package com.cherepovski;

public class Teacher extends Person {
    private int salary;


    public Teacher() {
    }

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ". salary=" + salary ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Teacher teacher = (Teacher) o;

        return salary == teacher.salary;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + salary;
        return result;
    }
}
