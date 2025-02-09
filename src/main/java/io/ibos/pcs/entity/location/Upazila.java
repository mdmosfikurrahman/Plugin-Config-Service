package io.ibos.pcs.entity.location;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Upazila {

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

    @Override
    public String toString() {
        return "Upazila{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameBn='" + nameBn + '\'' +
                ", districtId=" + (district != null ? district.getId() : null) +
                ", divisionId=" + (division != null ? division.getId() : null) +
                '}';
    }
}
