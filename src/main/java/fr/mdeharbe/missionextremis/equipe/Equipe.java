package fr.mdeharbe.missionextremis.equipe;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

@Data
@Document
public class Equipe {

    @org.springframework.data.annotation.Id
    private String id;
    private String name;
    private ArrayList<Perso> persos;

    public Equipe(String name, ArrayList<Perso> persos) {
        this.name = name;
        this.persos = persos;
    }
}
