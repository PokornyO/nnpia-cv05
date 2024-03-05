package com.example.nnpiacv02.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;


/*"update": Aktualizuje existující schéma podle entitních tříd. Pokud není schéma
vytvořeno, vytvoří ho.
"validate": Kontroluje, zda je schéma v souladu s entitními třídami. Neprovádí žádné
změny na databázi.
"create-drop": Vytvoří schéma při spuštění a odstraní ho při zavření SessionFactory.
Tato volba se používá především pro vývojové účely.
"none": Hibernate nebude provádět žádné akce vůči databázi. Je očekáváno, že schéma
je již vytvořeno a konfigurováno mimo Hibernate.*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private boolean active;
    private Date creation_date;
    private Date update_date;
    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();
    @ManyToMany(mappedBy = "users")
    private List<Role> roles = new ArrayList<>();

    public AppUser(String username, String password, boolean active, Date creation_date, Date update_date) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }
}
