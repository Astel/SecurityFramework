package com.astel.security.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @Id
    @Column(name = "role")
    private String role;
}
