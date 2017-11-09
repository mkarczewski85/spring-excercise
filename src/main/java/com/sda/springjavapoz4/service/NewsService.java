package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.News;
import com.sda.springjavapoz4.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UsersService usersService;

    public NewsService() {
    }

    @PostConstruct
    public void init() {

        newsRepository.save(generateNews());
        newsRepository.save(generateNews());
        newsRepository.save(generateNews());
        newsRepository.save(generateNews());
        newsRepository.save(generateNews());
        newsRepository.save(generateNews());
    }

    public List<News> getAllNews() {
        return StreamSupport.stream(newsRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public News getNews(long id) {
        return newsRepository.findOne(id);
    }

    public News generateNews() {
        News news = new News();
        news.setAuthor(usersService.getRandomUser());
        news.setTitle("Test");
        news.setDate(LocalDate.now());
        news.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!");
        news.setLargeImgPath("small.jpg");
        news.setSmallImgPath("large.jpg");
        return news;
    }

    public int saveNews(News news){
        return (int) newsRepository.save(news).getId();
    }

    public int saveNewsWithRandomUser(News news){
//        news.setAuthor(usersService.getRandomUser());
//        newsRepository.save(news);
        return 1;
    }


}
