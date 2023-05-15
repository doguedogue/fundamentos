package com.fundamentos.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @ManyToOne
    private User user;
}
