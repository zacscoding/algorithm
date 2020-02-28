package demo.springinterview.p2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

class Movie {
    public String name;
    public int year;
    public int rating;

    public Movie(String name, int year, int rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }
}

@Configuration
@Import(MovieRepository.class)
class Config {
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource ds) {
        return new JdbcTemplate(ds);
    }
}

@Repository
public class MovieRepository {

    private static final String INSERT_MOVIE = "INSERT INTO movies (name, year, rating) VALUES (?,?,?)";
    private static final String GET_MOVIES_NAME_LIKE = "SELECT * FROM movies WHERE name like ?";

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute(
                "CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), year int, rating int)");
    }

    public void createMovie(String name, int year, int rating) {
        Object[] params = new Object[] {
                name, year, rating
        };

        template.update(INSERT_MOVIE, params);
    }

    public List<Movie> findMoviesByName(String likeName) {
        Object[] params = new Object[] {
                likeName
        };

        return template.query(GET_MOVIES_NAME_LIKE, params, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                int rating = resultSet.getInt("rating");

                return new Movie(name, year, rating);
            }
        });
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
        config.register(Config.class);
        config.refresh();
        MovieRepository repository = config.getBean(MovieRepository.class);

        repository.createMovie("Some movie", 1974, 3);
        repository.createMovie("Some other movie", 1993, 2);

        List<Movie> movies = repository.findMoviesByName("Some%");
        for (Movie movie : movies) {
            System.out.println(movie.name + " - " + movie.year + " - " + movie.rating);
        }
    }
}