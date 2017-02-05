package movie.info.controller;

import movie.info.controllerHelper.LastQuery;
import movie.info.controllerHelper.SavedQuery;
import movie.info.controllerHelper.SearchHelper;
import movie.info.model.impl.Movie;
import movie.info.service.interfaces.GenreService;
import movie.info.service.interfaces.MovieService;
import movie.info.validators.MovieValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@SessionAttributes({"listGenres", "listMovies", "lastQuery", "searchHelper", "movieAddOrUpdate"})
public class MovieController {
    private static final Logger log = Logger.getLogger(MovieController.class);

    @Autowired
    private MovieService movieServiceImpl;

    @Autowired
    private GenreService genreServiceImpl;

    @Autowired
    private MovieValidator movieValidator;

    /**
     * получить список жанров и положить их в spring-сессию
     *
     * создать в spring-сессиии если их там нет: movieAddOrUpdate, searchHelper, lastQuery
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String start(Model model) {
        log.info("new listGenres");
        model.addAttribute("listGenres", genreServiceImpl.getAll());

        if (!model.containsAttribute("movieAddOrUpdate")) {
            log.info("new empty Movie");
            model.addAttribute("movieAddOrUpdate", new Movie());
        }

        if (!model.containsAttribute("searchHelper")) {
            log.info("new empty searchHelper");
            model.addAttribute("searchHelper", new SearchHelper());
        }

        if (!model.containsAttribute("lastQuery")) {
            log.info("new empty lastQuery");
            model.addAttribute("lastQuery", new LastQuery());
        }

        return "redirect:/lastQuery";
    }

    /**
     * получить последний запрос на выборку данных из сессии спринг
     */
    @RequestMapping(value = "/lastQuery", method = RequestMethod.GET)
    public String lastQuery(Model model, @ModelAttribute("lastQuery") LastQuery lastQuery) {
        // т.к. сюда перенаправило после удаления, добавления или изменения записи в БД,
        // то новый список будет отображен на jsp, т.е. выполнится последний запрос на получение данных
        if (lastQuery.getSavedQuery() == SavedQuery.MOVIES_BY_GENRE) {
            log.info("get listMovies by last query (id genre)");
            model.addAttribute("listMovies", genreServiceImpl.getById( Long.parseLong(lastQuery.getParameter()) ).getMovies());
        }
        if (lastQuery.getSavedQuery() == SavedQuery.MOVIES_BY_NAME) {
            log.info("get listMovies by last query (movie name)");
            model.addAttribute("listMovies", movieServiceImpl.getByName(lastQuery.getParameter()));
        }

        return "welcome";
    }

    /**
     * для редиректа (POST-REDIRECT-GET)
     */
    @RequestMapping(value = "/redirectWelcome", method = RequestMethod.GET)
    public String redirectWelcome() {
        log.info("only PRG");
        return "welcome";
    }

    /**
     * получить список фильмов по id жанра
     *
     * сохранить запрос в сессию
     */
    @RequestMapping(value = "/getMoviesByGenreId/{id}", method = RequestMethod.GET)
    public String getMoviesByGenreId(@PathVariable("id") long id, Model model) {
        log.info("getMoviesByGenreId and save lastQuery");
        model.addAttribute("listMovies", genreServiceImpl.getById(id).getMovies());

        // добавить запрос в сессию
        log.info("save lastQuery getMoviesByGenreId");
        model.addAttribute("lastQuery", new LastQuery(SavedQuery.MOVIES_BY_GENRE, String.valueOf(id)));

        return "welcome";
    }

    /**
     * получить список фильмов по строке
     */
    @RequestMapping(value = "/moviesByName", method = RequestMethod.POST)
    public String moviesByName(@ModelAttribute("searchHelper") SearchHelper searchHelper, Model model) {
        log.info("getMoviesByName and save lastQuery");
        model.addAttribute("listMovies", movieServiceImpl.getByName(searchHelper.getHelperName()));

        log.info("new searchHelper");
        model.addAttribute("searchHelper", new SearchHelper());

        log.info("save lastQuery getMoviesByName");
        model.addAttribute("lastQuery", new LastQuery(SavedQuery.MOVIES_BY_NAME, searchHelper.getHelperName()));

        return "redirect:/redirectWelcome";
    }

    /**
     * download pdf-document
     */
    @RequestMapping(value = "/downloadPDF/{id}", method = RequestMethod.GET)
    public String downloadPDF(@PathVariable("id") long id, Model model) {
        log.info("download PDF");
        model.addAttribute("movie", movieServiceImpl.getById(id));

        // pdfView - ключ в property файле
        return "pdfView";
    }

    /**
     * удалить фильм из БД
     */
    @RequestMapping(value = "/deleteMovie/{id}", method = RequestMethod.GET)
    public String deleteMovie(@PathVariable("id") int id) {
        log.info("deleteMovie");
        movieServiceImpl.delete(id);

        return "redirect:/welcome";
    }

    /**
     * получить кино по id для редактирования
     */
    @RequestMapping(value = "/getMovieById/{id}", method = RequestMethod.GET)
    public String getMovieById(@PathVariable("id") int id, Model model) {
        log.info("get movie by id");
        model.addAttribute("movieAddOrUpdate", movieServiceImpl.getById(id));

        return "welcome";
    }

    /**
     * добавить или редактировать
     */
    @RequestMapping(value = "/addOrUpdateMovie", method = {RequestMethod.POST, RequestMethod.GET})
    public String addOrUpdateMovie(@ModelAttribute("movieAddOrUpdate") Movie movie, BindingResult result, Model model) {
        MultipartFile file = movie.getFile();

        movieValidator.validate(movie, result);
        if (result.hasErrors()) {
            log.info("movieValidator has errors");
            return "welcome";
        }

        log.info("new movieAddOrUpdate");
        model.addAttribute("movieAddOrUpdate", new Movie());

        if(movie.getId() == 0) {
            try {
                byte[] bytes = file.getBytes();
                movie.setImage(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("add new movie");
            movieServiceImpl.add(movie);
        } else { //movie.getId() != 0
            try {
                if (!file.isEmpty()) {
                    byte[] bytes = file.getBytes();
                    movie.setImage(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            log.info("update movie");
            movieServiceImpl.update(movie);
        }

        return "redirect:/welcome";
    }
}
