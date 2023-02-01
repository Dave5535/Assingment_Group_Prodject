package se.lexicon.assingment_group_prodject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(unique = true)
    private String ingredientName;
    
    public Ingredient( String ingredientName ) {
        this.ingredientName = ingredientName;
    }
}
