package me.anna.demo.controllers;

import me.anna.demo.models.Actor;
import me.anna.demo.models.Movie;
import me.anna.demo.repositories.ActorRepository;
import me.anna.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;


    @RequestMapping("/")
    public @ResponseBody String showIndex()
    {
        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealName("Sandra Mae Bullowski");
        actorRepository.save(a);

        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

//        movie.addActor(a);

        movieRepository.save(movie);

        return "results added";
    }
}
