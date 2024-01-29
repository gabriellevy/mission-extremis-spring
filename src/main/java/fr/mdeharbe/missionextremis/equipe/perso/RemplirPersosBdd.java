package fr.mdeharbe.missionextremis.equipe.perso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class RemplirPersosBdd {

    /**
     * revide et recrée la bdd à chaque lancement
     * (un peu bourrin mais pratique pour les tests, on va laisser comme ça pour l'instant)
     */
    @Bean({"initPersosBdd"})
    CommandLineRunner init(MongoOperations mongoOperations) {
        return args -> {
            mongoOperations.dropCollection(Perso.class);

            mongoOperations.insert(new Perso("Gregor Lustig"));
            mongoOperations.insert(new Perso("Werner Murrmann"));
            mongoOperations.insert(new Perso("L'onnête Ottokar Johanson"));
            mongoOperations.insert(new Perso("Amris Pluiedebraise"));
            mongoOperations.insert(new Perso("Gotthard Wallenstein"));
            mongoOperations.insert(new Perso("Detlef Sierck"));
            mongoOperations.insert(new Perso("Petra Liebkosen"));
            mongoOperations.insert(new Perso("Salundra Von Drakenberg"));
            mongoOperations.insert(new Perso("Gunnar Hrolfsson"));
            mongoOperations.insert(new Perso("Golthog"));
            mongoOperations.insert(new Perso("Adolphus Kuftsos"));
            mongoOperations.insert(new Perso("Malmir Giluviel"));
            mongoOperations.insert(new Perso("Else Sigloben"));
            mongoOperations.insert(new Perso("Pandora 'pois' Pochegarée"));
            mongoOperations.insert(new Perso("Sven Barbedrue"));
            mongoOperations.insert(new Perso("Wanda Grimmig"));
            mongoOperations.insert(new Perso("Ferdinand Gruber"));
            mongoOperations.insert(new Perso("Wanda Weltschmertz"));
            mongoOperations.insert(new Perso("Erina Eberhauer"));
            mongoOperations.insert(new Perso("Renate Hausier"));
            mongoOperations.insert(new Perso("Johann 'dam de nage' Dassbüt"));
            mongoOperations.insert(new Perso("Molrella Tuilecaramel"));
            mongoOperations.insert(new Perso("Kristen Krank"));
            mongoOperations.insert(new Perso("Marta Gerbenshreiber"));
            mongoOperations.insert(new Perso("Tanoa Brancheclair"));
            mongoOperations.insert(new Perso("Harbull Piedvelu"));

            mongoOperations.findAll(Perso.class).forEach(perso -> {
                System.out.println(perso.toString());
            });
        };
    }
}
