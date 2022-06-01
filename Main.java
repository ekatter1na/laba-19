package com.metanit;

import java.util.ArrayList;
import java.util.List;

interface Observable {//интерфейс издателя
    void notifyObservers();
    void regObserver(Observer observer);
}
interface Observer{//интерфейс подписчика
    void Notification(String news);
}
class Groups implements Observable{
    List<Observer> list = new ArrayList<>();
    String news;
    void setNews(String news){
        this.news = news;
        notifyObservers();//уведомляет подписчиков
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: list){
            observer.Notification(news);//обновляет новость
        }
    }

    @Override
    public void regObserver(Observer observer) {
        list.add(observer);//подписывает пользователя
    }
}
class Subscribers implements Observer{
    String name;
    public Subscribers(String name){
        this.name = name;
    }

    @Override
    public void Notification(String news) {
        System.out.println(name + " получил оповещение: " + news);//метод оповещения
    }
}
public class Main {
    public static void main(String[] args) {
        Groups Rdsgp = new Groups();
        Groups Nr = new Groups();
        Groups Piratedrife = new Groups();
        Groups Kotiki = new Groups();

        Subscribers sub1 = new Subscribers("Niklaus");
        Subscribers sub2 = new Subscribers("Damon");

        Rdsgp.regObserver(sub1);
        Rdsgp.regObserver(sub2);
        Nr.regObserver(sub1);
        Nr.regObserver(sub2);
        Piratedrife.regObserver(sub1);
        Piratedrife.regObserver(sub2);
        Kotiki.regObserver(sub2);

        Rdsgp.setNews("Георгий Чивчан занял 1 место в Нижнем Новгороде" + "\n");
        Nr.setNews("Российские кинотеатры на фоне дефицита начнут показавыть новые сериалы" + "\n");
        Piratedrife.setNews("Классификация и парные 2 этапа Gorilla Drift" + "\n");
        Kotiki.setNews("Котик хочет играть" + "\n");

    }
}
