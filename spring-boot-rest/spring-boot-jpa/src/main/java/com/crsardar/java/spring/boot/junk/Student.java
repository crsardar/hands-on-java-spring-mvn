package com.crsardar.java.spring.boot.junk;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    private Passport passport;

    protected Student()
    {
    }

    public Student(String name, Passport passport)
    {
        this.name = name;
        this.passport = passport;
    }

    public Long getId()
    {
        return id;
    }

    public Student(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Passport getPassport()
    {
        return passport;
    }

    public void setPassport(Passport passport)
    {
        this.passport = passport;
    }

    @Override
    public String toString()
    {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + "}";
    }
}
