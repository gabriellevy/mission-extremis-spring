package fr.mdeharbe.missionextremis.mission;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Scene {

    @org.springframework.data.annotation.Id
    private String id;
    private String nom;

    public Scene(String nom) {
        this.nom = nom;
    }
}
