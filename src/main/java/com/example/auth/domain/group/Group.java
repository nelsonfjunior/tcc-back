package com.example.auth.domain.group;

import java.util.List;

import com.example.auth.domain.publish.Publish;
import com.example.auth.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id; 
    private String name;
    private String description;
    private String image_name;
    private byte[] image;

    @ManyToOne
    private User adm;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;

    @OneToMany
    private List<Publish> publishs;
}
