package com.bandipo.blogapi.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data@NoArgsConstructor@AllArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    //The user handles this mapping by creating a field named "location_id"
    private Location location;

    //when we add @OneToMany in User,
    //The User Entity decides to do the mapping

    //The mappedBy is an attribute of the @OneToMany relationship.
    // You use the mappedBy to tell the @OneToMany annotation that
    // the relationship has already been handled using a foreign key in the corresponding entity.
    // In this way, an additional table is not created.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)// so mapping is done by the user field in the Post entity
    private List<Post> posts;


}
