package org.tms.lesson36.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.tms.lesson36.model.Car;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClientDto {

    private String name;
    private List<Car> cars;
}
