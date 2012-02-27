package fr.valtech.coursDuSoir.mongodb;

import static com.mongodb.Mongo.connect;
import static com.mongodb.ServerAddress.defaultHost;
import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.DBAddress;

import fr.valtech.coursDuSoir.mongodb.model.Clipart;

public class WriteAccessTest {

    @Before
    public void with_database_writetest_create_data() throws UnknownHostException, IOException {
        MongoCourDuSoir mongoCourDuSoir = new MongoCourDuSoirImpl();
        mongoCourDuSoir.with_writetest_database_create_data("Code Story logo", "ericlemerdy",
                "http://openclipart.org/user-detail/ericlemerdy");
        mongoCourDuSoir.with_writetest_database_create_data("PC LAPTOP NOTEBOOK", "Keistutis",
                "http://openclipart.org/user-detail/Keistutis");
        mongoCourDuSoir.with_writetest_database_create_data("PC LAPTOP NOTEBOOK", "ericlemerdy",
                "http://openclipart.org/user-detail/ericlemerdy");
    }

    @After
    public void with_database_writetest_drop_it() throws UnknownHostException {
        connect(new DBAddress(defaultHost(), "writetest")).dropDatabase();
    }

    @Test
    public void with_database_writetest_should_reattribute_clipart_to_Keistutis() throws UnknownHostException {
        MongoCourDuSoir mongoCourDuSoir = new MongoCourDuSoirImpl();
        mongoCourDuSoir.with_writetest_database_reattribute_clipart_entitled_PC_LAPTOP_NOTEBOOK();

        Iterator<Clipart> keistutisCliparts = mongoCourDuSoir
                .with_writetest_database_find_cliparts_entitled_PC_LAPTOP_NOTEBOOK().iterator();
        while (keistutisCliparts.hasNext()) {
            Clipart nextClipart = keistutisCliparts.next();
            assertThat(nextClipart.getTitle()).isEqualTo("PC LAPTOP NOTEBOOK");
            assertThat(nextClipart.getUploader().getName()).isEqualTo("Keistutis");
        }
    }

}
