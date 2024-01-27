package fr.mdeharbe.missionextremis.equipe.perso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "persos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perso {

    @org.springframework.data.annotation.Id
    private String id;
    private String nom;
    private Boolean selectionne;

    @Autowired
    public Perso(String nom, Boolean selectionne) {
        this.nom = nom;
        this.selectionne = selectionne;
    }
}
