package com.example.jpa.bookmanager.domain;

import com.example.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@EntityListeners(UserEntityListener.class)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    List<UserHistory> userHistories = new ArrayList<>();

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

//    @Transient  // DB 데이터에 반영 되지 않는다
//    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;
//
//    @PrePersist // Insert 되기 전에 실행
//    @PreUpdate // merge 되기 전에 실행
//    @PreRemove // delete 되기 전에 실행
//    @PostPersist
//    @PostUpdate
//    @PostRemove
//    @PostLoad // select 조회 이후 실행되는 메서드
//
//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PostPersist
//    public void postPersist() {
//        System.out.println(">>>> postPersit");
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PostUpdate
//    public void postUpdate() {
//        System.out.println(">>>> postUpdate");
//    }
//
//    @PreRemove
//    public void preRemove() {
//        System.out.println(">>>> preRemove");
//    }
//
//    @PostRemove
//    public void postRemove() {
//        System.out.println(">>>> postRemove");
//    }
//
//    @PostLoad
//    public void postLoad() {
//        System.out.println(">>>> postLoad");
//    }
}
