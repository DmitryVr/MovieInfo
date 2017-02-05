package movie.info.model.impl;

import movie.info.model.abstracts.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie extends Model {
    @Column(name = "nameRussian")
    private String nameRussian;

    @Column(name = "nameOriginal")
    private String nameOriginal;

    @Column(name = "image")
    private byte image[];

    @Column(name = "year")
    private String year;

    @Column(name = "country")
    private String country;

    @Column(name = "director")
    private String director;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "description")
    private String description;

    @Transient
    private MultipartFile file;

    public Movie() {
        super();
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public void setNameRussian(String nameRussian) {
        this.nameRussian = nameRussian;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (nameRussian != null ? !nameRussian.equals(movie.nameRussian) : movie.nameRussian != null) return false;
        if (nameOriginal != null ? !nameOriginal.equals(movie.nameOriginal) : movie.nameOriginal != null) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;
        if (country != null ? !country.equals(movie.country) : movie.country != null) return false;
        if (director != null ? !director.equals(movie.director) : movie.director != null) return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        return description != null ? description.equals(movie.description) : movie.description == null;

    }

    @Override
    public int hashCode() {
        int result = nameRussian != null ? nameRussian.hashCode() : 0;
        result = 31 * result + (nameOriginal != null ? nameOriginal.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
