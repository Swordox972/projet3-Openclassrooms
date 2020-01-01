package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d",
                    "+33 6 52 47 14", "Bonjour!Je souhaiterais faire de la marche nordique." +
                    " Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner!" +
                    " J'aime les jeux de carte tels la belote ou le tarot"),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e", "+33 6 52 45 41 14",
                    "Bonjour! Je recherche quelqu'un pour m'aider à entretenir mon jardin!"),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f", "+33 6 52 15 21 61",
                    "Bonjour! Je souhaite organiser une fête chez moi, vous êtes le bienvenue!"),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a", "+33 6 52 78 41 14",
                    "Yo! Dans le cadre d'un voyage, je souhaiterais que quelqu'un s'occupe de mon chien en mon abscence"),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b", "+33 6 52 74 84 54",
                    "Salut, etant fan de selfie je voudrais créer un club où on posterait des photos de nous! "),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c", "+33 6 52 33 14 52",
                    "Bonjour, suite à une fracture du tibia, je souhaiterais que quelqu'un puisse m'aider à faire les courses, merci d'avance!"),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d", "+33 6 52 87 94 54",
                    "Wesh, ça intéresse quelqu'un de faire du sport avec moi?"),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b", "+33 6 52 20 30 21",
                    "Yo, étant un fan de jeux vidéo, si vous êtes intéressé contactez moi :)!"),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "+33 6 52 47 36 21",
                    "Salut, je suis intéressé par la pèche, qui aime aussi me suive!!"),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d", "+33 6 52 95 47 32",
                    "Salut, j'adore faire la fête, si vous faîtes une soirée n'hésitez pas à m'appeler!!"),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d", "+33 6 52 75 84 74",
                    "Salut, j'adore faire de la pèche sous-marine et ramasser des étoiles de mer, si vous voulez vous joindre ce sera avec plaisir"),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d", "+33 6 52 74 74 54",
                    "Yo! Je suis fan de footBall et regarde souvent les matchs sur ma télévision 4k, si vous êtes intéressés vous savez quoi faire!")
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }

    public static List<Neighbour> DUMMY_FAVORITE_NEIGHBOURS = new ArrayList<>();

    static List<Neighbour> generateFavoriteNeighbours() {
        return new ArrayList<>(DUMMY_FAVORITE_NEIGHBOURS);
    }
}
