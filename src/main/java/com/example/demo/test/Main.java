package com.example.demo.test;

import com.example.demo.domain.Film;
import com.example.demo.domain.Genre;
import com.example.demo.domain.Rating;

public class Main {

    public static void main(String[] args) {
        Film prviFilm = new Film();
        Film drugiFilm = new Film();

        prviFilm.setId(1);

        prviFilm.setName("Spiderman 3");
        prviFilm.setRating(Rating.NC17);
        prviFilm.setDirector("James Cameron");
        prviFilm.setDuration(Short.valueOf("100"));
        prviFilm.setGenre(Genre.ACTION);

        drugiFilm.setId(1);

        drugiFilm.setName("Spiderman 3");
        drugiFilm.setRating(Rating.NC17);
        drugiFilm.setDirector("James Cameron");
        drugiFilm.setDuration(Short.valueOf("100"));
        drugiFilm.setGenre(Genre.ACTION);

        if(prviFilm.equals(drugiFilm)) {
            System.out.println("Isti su!");
        }
        else {
            System.out.println("Nisu isti!");
        }
    }



}
