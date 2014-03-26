package biat.services;

import java.util.List;

import javax.ejb.Remote;

import biat.domain.News;

@Remote
public interface NewsServiceRemoteRemote {
public void createNews(News news);
public void removeNews(News news);
public News findnews(String date);
public List<News>DisplayAllNews();

}
