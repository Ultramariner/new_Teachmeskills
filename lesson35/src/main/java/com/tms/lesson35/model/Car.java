package com.tms.lesson35.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "f_number")
    private String number;
    @Column(name = "f_model")
    @Enumerated(EnumType.STRING)
    private MODEL model;
    @Column(name = "f_release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(name = "f_creation_date")
    @CreationTimestamp
    private Date creationDate;
    @Column(name = "f_update_date")
    @UpdateTimestamp
    private Date updateDate;
    @Column(name = "f_in_stock")
    private boolean inStock;
    @Column(name = "f_version")
    @Version
    private  int version;

    public Car(String number, MODEL model, boolean inStock) {
        this.number = number;
        this.model = model;
        this.inStock = inStock;
    }

    public String getNumber() { return number; }
}
