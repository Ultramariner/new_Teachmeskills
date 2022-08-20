package org.tms.lesson36.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer id;
    @Column(name = "f_name")
    private String name;
    @OneToMany
    private List<Car> cars;

    public Client(String name) {
        this.name = name;
    }
}

