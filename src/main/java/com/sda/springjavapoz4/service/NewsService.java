package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    List<News> newsList;

    @Autowired
    UsersService usersService;

    public NewsService() {
    }

    @PostConstruct
    public void init() {
        this.newsList = new ArrayList<>();
        newsList.add(generateNews());
        newsList.add(generateNews());
        newsList.add(generateNews());
        newsList.add(generateNews());
        newsList.add(generateNews());
        newsList.add(generateNews());
    }

    public List<News> getAllNews() {
        return newsList;
    }

    public News getNews(long id) {
        Optional<News> news = newsList.stream().filter(n -> n.getId() == id).findFirst();
        if (news.isPresent()) {
            return news.get();
        }
        return null;
    }

    public News generateNews() {
        News news = new News();
        news.setId((long) newsList.size());
        news.setAuthor(usersService.getExampleUser());
        news.setTitle("Test");
        news.setDate(LocalDate.now());
        news.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!");
        news.setLargeImgPath("small.jpg");
        news.setSmallImgPath("large.jpg");
        return news;
    }

    public void saveNews(News news){
        news.setId((long) newsList.size());
        news.setAuthor(usersService.getRandomUser());
        newsList.add(news);
    }


}
