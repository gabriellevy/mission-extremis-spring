package fr.mdeharbe.missionextremis.mission;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "missions")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mission {

    @org.springframework.data.annotation.Id
    public String id;
    @NotBlank(message="La mission doit avoir un nom.")
    public String name;
    public ArrayList<Scene> scenes;

    public Mission(String name, ArrayList<Scene> scenes) {
        this.name = name;
        this.scenes = scenes;
    }
}
