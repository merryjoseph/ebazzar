package com.sayone.ebazzar.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","address"})
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID= 5174137885820647783L;
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long userId;
    @Column(nullable = false,length = 50)
    private String firstName;
    @Column(nullable = false,length = 50)
    private String lastName;
    @Column(nullable = false,length = 120)
    private String email;
    @Column(nullable = false,length = 25)
    private String password;
    @Column(nullable = false,length = 25)
    private int phoneNumber;
    @Column
    private String encryptedPassword;
    @Column(nullable = false,length = 50)
    private String userType;
    private String emailVerificationToken;
    @Column
    private Boolean emailVerificationStatus=false;
    @Column
    private Boolean  userStatus;
    @UpdateTimestamp
    private LocalDateTime updatedTime;
    @CreationTimestamp
    private LocalDateTime createTime;
    @OneToMany(targetEntity = AddressEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private List<AddressEntity> address;
    public UserEntity() {
    }
    public UserEntity(String firstName, String lastName, String email,
                      String password, int phoneNumber, String userType) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public List<AddressEntity> getAddress() {
        return address;
    }
    public void setAddress(List<AddressEntity> address) {
        this.address = address;
    }
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }
    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }
    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }
    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
    public Boolean getUserStatus() {
        return userStatus;
    }
    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }
}
