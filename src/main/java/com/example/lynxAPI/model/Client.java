package com.example.lynxAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "curatedClient")
public class Client {

    @Id
    private long id;

    private String enrollment;
    private double salary;
    private boolean atRisk;
    private boolean gambling;
    private boolean crypto;

    public Client () {}

    public Client(long id, String enrollment, double salary, boolean atRisk, boolean gambling, boolean crypto) {
        this.enrollment = enrollment;
        this.salary = salary;
        this.atRisk = atRisk;
        this.gambling = gambling;
        this.crypto = crypto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isAtRisk() {
        return atRisk;
    }

    public void setAtRisk(boolean atRisk) {
        this.atRisk = atRisk;
    }

    public boolean isGambling() {
        return gambling;
    }

    public void setGambling(boolean gambling) {
        this.gambling = gambling;
    }

    public boolean isCrypto() {
        return crypto;
    }

    public void setCrypto(boolean crypto) {
        this.crypto = crypto;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", enrollment='" + enrollment + '\'' +
                ", salary=" + salary +
                ", atRisk=" + atRisk +
                ", gambling=" + gambling +
                ", crypto=" + crypto +
                '}';
    }
}
