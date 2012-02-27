package fr.valtech.coursDuSoir.mongodb;

import static org.fest.assertions.Assertions.assertThat;

import java.net.UnknownHostException;
import java.util.Iterator;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Ignore;
import org.junit.Test;

import com.mongodb.DB;

import fr.valtech.coursDuSoir.mongodb.model.Clipart;
import fr.valtech.coursDuSoir.mongodb.model.Uploader;

public class MongoCoursDuSoirTest {

    @Test
    public void should_create_db() throws UnknownHostException {
        MongoCourDuSoir mongoCourDuSoir = new MongoCourDuSoirImpl();
        DB db = mongoCourDuSoir.connect_tip_use_Mongo_object();
        assertThat(db.toString()).isEqualTo("test");
    }

    @Test
    public void should_create_Jongo() throws UnknownHostException {
        MongoCourDuSoir mongoCourDuSoir = new MongoCourDuSoirImpl();
        Jongo jongo = mongoCourDuSoir.create_tip_use_jongo_object();
        assertThat(jongo).isNotNull();
    }

    @Test
    public void should_get_cliparts_collection() throws UnknownHostException {
        MongoCourDuSoir mongoCourDuSoir = new MongoCourDuSoirImpl();
        MongoCollection cliparts = mongoCourDuSoir.get_cliparts_collection();
        assertThat(cliparts.getName()).isEqualTo("cliparts");
    }

    @Test
    public void should_count_cliparts() throws UnknownHostException {
        MongoCourDuSoir mongoCourDuSoir = new MongoCourDuSoirImpl();
        assertThat(mongoCourDuSoir.count_cliparts()).isEqualTo(3);
    }

    @Test
    public void should_find_cliparts_entitled_CodeStoryLogo() throws UnknownHostException {
        MongoCourDuSoir mongoCourDuSoir = new MongoCourDuSoirImpl();
        Iterator<Clipart> cliparts_entitled_CodeStoryLogo = mongoCourDuSoir.find_cliparts_entitled_CodeStoryLogo()
                .iterator();
        Clipart clipart_entitled_CodeStoryLogo = cliparts_entitled_CodeStoryLogo.next();
        assertThat(clipart_entitled_CodeStoryLogo.getTitle()).isEqualTo("Code Story logo");
        assertThat(cliparts_entitled_CodeStoryLogo.hasNext()).isFalse();
    }

    @Test
    public void should_find_Keistutis_uploader() throws UnknownHostException {
        MongoCourDuSoir mongoCourDuSoir = new MongoCourDuSoirImpl();
        Uploader keistutis = mongoCourDuSoir.find_Keistutis_uploader();
        assertThat(keistutis.getName()).isEqualTo("Keistutis");
        assertThat(keistutis.getHref()).isEqualTo("http://openclipart.org/user-detail/Keistutis");
    }

}
