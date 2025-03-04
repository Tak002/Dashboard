package com.example.dashboard.entity;

import com.example.dashboard.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor //for jpa eneity
@AllArgsConstructor //for builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true) // email은 NOT NULL & UNIQUE
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) // ENUM 타입으로 저장 (DB에는 VARCHAR로 저장됨)
    @Column(nullable = false)
    private Role role;

    @PrePersist
    @PreUpdate
    public void prePersist(){
        if (this.email==null|| this.email.isEmpty()){
            throw new IllegalArgumentException("이메일은 필수 입력 값입니다.");
        }

        if (this.password==null|| this.password.isEmpty()){
            throw new IllegalArgumentException("비밀번호는 필수 입력 값입니다.");
        }
    }
}

