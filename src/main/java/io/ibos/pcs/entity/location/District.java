package io.ibos.pcs.entity.location;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class District {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, name = "name_bn")
    private String nameBn;

    @Column(nullable = false, unique = true)
    private String coordinates;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Upazila> upazilas;

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameBn='" + nameBn + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", divisionId=" + (division != null ? division.getId() : null) +
                '}';
    }
}

