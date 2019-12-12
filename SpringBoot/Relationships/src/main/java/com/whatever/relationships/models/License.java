package com.whatever.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * License
 */
// ...
@Entity
@Table(name="licenses")
public class License {
    

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static String number = "000001";
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date expirationDate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;



    // Constructors
    public License() {
    }
    public License(Long id, Date expirationDate, String state, Date createdAt, Date updatedAt, Person person) {
        this.id = id;
        this.expirationDate = expirationDate;
        this.number = numberIncrementer();
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.person = person;
    }

    public static String numberIncrementer(){
        int i = Integer.parseInt(number);
        i++;
        String str = String.format("%06d", i);
        return str;
    }

    // getters and setters removed for brevity

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Date getExpirationDate() {
        return this.expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Person getPerson() {
        return this.person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }


    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
}

