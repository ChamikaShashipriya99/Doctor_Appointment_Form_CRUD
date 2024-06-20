package com.appointment.model;

public class Appointment {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private String gender;
    private String email;
    private String appointmentType;
    private String doctorType;

    // Constructor for creating a new appointment (without id)
    public Appointment(String name, int age, String phoneNumber, String gender, String email, String appointmentType, String doctorType) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.appointmentType = appointmentType;
        this.doctorType = doctorType;
    }

    // Constructor for updating an existing appointment (with id)
    public Appointment(int id, String name, int age, String phoneNumber, String gender, String email, String appointmentType, String doctorType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.appointmentType = appointmentType;
        this.doctorType = doctorType;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }
}