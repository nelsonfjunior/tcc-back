package com.example.auth.domain.publish;

import java.time.LocalDateTime;
import java.util.List;

import com.example.auth.domain.commentary.Commentary;
import com.example.auth.domain.group.Group;
import com.example.auth.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private LocalDateTime whenSent;
    
    @ManyToOne
    private User author;

    @OneToMany
    private List<Commentary> commentaries;

    @OneToMany 
    private List<Group> groups;
}
