package movie.info.controller;

import movie.info.model.impl.Movie;
import movie.info.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class ImageController {
    @Autowired
    private MovieService movieServiceImpl;

    @RequestMapping(value = "/movieImage/{id}/{save}", method = RequestMethod.GET)
    public void ok(@PathVariable("id") long id,
                   @PathVariable("save") boolean save,
                   HttpServletResponse response) {
        Movie movie = movieServiceImpl.getById(id);
        response.setContentType("image/jpeg");
        response.setContentLength(movie.getImage().length);

        if (save) {
            // меню сохранения
            try {
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(movie.getNameRussian(),"UTF-8") + ".jpg");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        try {
            // отправить байты в response
            response.getOutputStream().write(movie.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
