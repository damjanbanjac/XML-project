package com.microservices.ordering.model;

import com.microservices.ordering.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="UserOrder")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
public class Users {
    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;
    private String name;
    private String email;

    /*
    @OneToMany(fetch = FetchType.EAGER)
    public List<Order> orders;*/

    public Users(Long idUser) {
        this.id = idUser;
    }

    public Users(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
    }

}
