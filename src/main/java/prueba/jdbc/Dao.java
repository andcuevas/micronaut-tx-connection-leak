package prueba.jdbc;

import org.jooq.DSLContext;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.UUID;

import static gen.db.Tables.*;

@Singleton
@Transactional
public class Dao {

    private final DSLContext dslContext;

    public Dao(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public void insert(String someText) {
        dslContext.insertInto(
                TEST_TABLE,
                TEST_TABLE.KEY,
                TEST_TABLE.SOME_TEXT)
                .values(
                        UUID.randomUUID().toString(),
                        someText)
                .execute();
    }
}
