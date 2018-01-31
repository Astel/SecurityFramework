package com.astel.security.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "credentials")
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @NonNull
    @Column(name = "username")
    private String username;

    @Basic
    @NonNull
    @Column(name = "password")
    private String password;
}
