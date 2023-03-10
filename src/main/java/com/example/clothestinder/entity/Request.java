package com.example.clothestinder.entity;


import com.example.clothestinder.entity.enums.Tonality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userId;
    @Column
    private Timestamp creationDate;//todo v3
    @Column
    private Long bpmMin;
    @Column
    private Long bpmMax;
    @Column
    @Enumerated(EnumType.STRING)
    private Tonality tonality; //todo

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "request_tags",
            joinColumns = { @JoinColumn(name = "request_id")},
            inverseJoinColumns = { @JoinColumn(name = "tag_id")}
    )
    Set<Tag> tags;
}
