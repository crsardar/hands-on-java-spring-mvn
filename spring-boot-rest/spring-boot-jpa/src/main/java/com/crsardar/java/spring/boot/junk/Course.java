package com.crsardar.java.spring.boot.junk;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = { @NamedQuery(name = "select_all_courses", query = "SELECT c FROM Course c"),
@NamedQuery(name = "select_spring_courses", query = "SELECT c FROM Course c WHERE name LIKE 'Spring%'")})
public class Course
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDate creationTime;

    @UpdateTimestamp
    private LocalDate lastUpdateTime;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students  = new ArrayList<>();

    protected Course()
    {
    }

    public Course(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getCreationTime()
    {
        return creationTime;
    }

    public void setCreationTime(LocalDate creationTime)
    {
        this.creationTime = creationTime;
    }

    public LocalDate getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDate lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review)
    {
        reviews.add(review);
    }

    public boolean removeReview(Review review)
    {
        return reviews.remove(review);
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void addStudent(Student student)
    {
        this.students.add(student);
    }

    public boolean removeStudent(Student student)
    {
        return students.remove(student);
    }

    @Override
    public String toString()
    {
        return "Course{" + "name='" + name + '\'' + ", creationTime=" + creationTime + ", lastUpdateTime=" + lastUpdateTime + '}';
    }
}
