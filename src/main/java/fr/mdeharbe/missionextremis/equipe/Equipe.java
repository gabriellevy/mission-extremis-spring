package fr.mdeharbe.missionextremis.equipe;

import fr.mdeharbe.missionextremis.equipe.perso.Perso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

@Data
@Document(collection = "equipes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {

    @org.springframework.data.annotation.Id
    private String id;
    private ArrayList<Perso> persos;

}
