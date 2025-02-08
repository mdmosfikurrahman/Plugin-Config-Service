package io.ibos.pcs.entity.location;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Upazilla {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, name = "name_bn")
    private String nameBn;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

}
