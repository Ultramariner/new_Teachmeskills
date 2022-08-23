package org.tms.lesson36.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
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
    @ManyToMany
    private List<Region> regions;

    public Car(String number, MODEL model) {
        this.number = number;
        this.model = model;
    }
}