package org.tms.lesson36.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.tms.lesson36.model.MODEL;
import org.tms.lesson36.model.Region;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarDto {

    private String number;
    private MODEL model;
    private Date releaseDate;
    private List<Region> regions;
}
