package prueba.jdbc;

import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Singleton;

@Singleton
public class TestScheduler {

    private final Dao dao;

    public TestScheduler(Dao dao) {
        this.dao = dao;
    }

    @Scheduled(fixedDelay = "2s")
    void run() {
        handle();
    }

    public void handle() {
        dao.insert("text.");
    }

}
