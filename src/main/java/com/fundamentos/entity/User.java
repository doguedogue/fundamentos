package com.fundamentos.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    public User(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public User(Long id) {
        this.id = id;
    }
}
