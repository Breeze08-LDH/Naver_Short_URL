package com.breeze.springapi.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "SHORT_URL")
public class ShortUrlEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, unique = true)
    private String HASH;

    @Column(nullable = false, unique = true)
    private String URL;

    @Column(nullable = false, unique = true)
    private String ORGURL;
}
