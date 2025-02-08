package io.ibos.pcs.entity.location;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Division {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, name = "name_bn")
    private String nameBn;

    @Column(nullable = false, unique = true)
    private String coordinates;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<District> districts;

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameBn='" + nameBn + '\'' +
                ", coordinates='" + coordinates + '\'' +
                '}';
    }
}

