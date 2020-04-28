package com.spangular.spangular.database.sqlserver.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import com.fasterxml.jackson.databind.PropertyNamingStrategy;
// import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.hibernate.annotations.GenericGenerator;

/**
 * Bike
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // This helps to ignore the handler
// @JsonNaming(PropertyNamingStrategy.cam.class)
public class Bike {

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Id
    private UUID Id;
    private String Name;
    private String Email;
    private String Phone;
    private String Model;
    private String SerialNumber;
    private BigDecimal PurchasePrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("purchaseDate")
    private Date PurchaseDate;
    private boolean Contact;

    
    public UUID getId() {
        return this.Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getModel() {
        return this.Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getSerialNumber() {
        return this.SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public BigDecimal getPurchasePrice() {
        return this.PurchasePrice;
    }

    public void setPurchasePrice(BigDecimal PurchasePrice) {
        this.PurchasePrice = PurchasePrice;
    }

    public Date getPurchaseDate() {
        return this.PurchaseDate;
    }

    public void setPurchaseDate(Date PurchaseDate) {
        this.PurchaseDate = PurchaseDate;
    }

    public boolean isContact() {
        return this.Contact;
    }

    public boolean getContact() {
        return this.Contact;
    }

    public void setContact(boolean Contact) {
        this.Contact = Contact;
    }
    

    
}