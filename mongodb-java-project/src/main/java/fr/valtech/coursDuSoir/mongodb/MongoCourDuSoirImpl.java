package fr.valtech.coursDuSoir.mongodb;

import static com.mongodb.ServerAddress.defaultHost;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.Mongo;

import fr.valtech.coursDuSoir.mongodb.model.Clipart;
import fr.valtech.coursDuSoir.mongodb.model.Uploader;

public class MongoCourDuSoirImpl implements MongoCourDuSoir {

    @Override
    public DB connect_tip_use_Mongo_object() throws UnknownHostException {
        return Mongo.connect(new DBAddress(defaultHost(), "test"));
    }

    @Override
    public Jongo create_tip_use_jongo_object() throws UnknownHostException {
        return new Jongo(connect_tip_use_Mongo_object());
    }

    @Override
    public MongoCollection get_cliparts_collection() throws UnknownHostException {
        return create_tip_use_jongo_object().getCollection("cliparts");
    }

    @Override
    public Long count_cliparts() throws UnknownHostException {
        return get_cliparts_collection().count("{}");
    }

    @Override
    public Iterable<Clipart> find_cliparts_entitled_CodeStoryLogo() throws UnknownHostException {
        return get_cliparts_collection().find("{title:\"Code Story logo\"}").as(Clipart.class);
    }

    @Override
    public Uploader find_Keistutis_uploader() throws UnknownHostException {
        return get_cliparts_collection().findOne("{\"uploader.name\":\"Keistutis\"}").fields("{uploader:1}")
                .as(Clipart.class).getUploader();
    }

    @Override
    public void with_writetest_database_create_data(String title, String name, String href)
            throws UnknownHostException, IOException {
        DB db = Mongo.connect(new DBAddress(defaultHost(), "writetest"));
        Jongo jongo = new Jongo(db);
        jongo.getCollection("cliparts").save(new Clipart(title, new Uploader(name, href)));
    }

    @Override
    public void with_writetest_database_reattribute_clipart_entitled_PC_LAPTOP_NOTEBOOK() throws UnknownHostException {
        DB db = Mongo.connect(new DBAddress(defaultHost(), "writetest"));
        Jongo jongo = new Jongo(db);
        jongo.getCollection("cliparts").update( //
                "{title:\"PC LAPTOP NOTEBOOK\", \"uploader.name\":\"ericlemerdy\"}",//
                "{$set:{uploader:{" + //
                        "name:\"Keistutis\"," + //
                        "href:\"http://openclipart.org/user-detail/Keistutis\"" + //
                        "}}}");
    }

    @Override
    public Iterable<Clipart> with_writetest_database_find_cliparts_entitled_PC_LAPTOP_NOTEBOOK()
            throws UnknownHostException {
        DB db = Mongo.connect(new DBAddress(defaultHost(), "writetest"));
        Jongo jongo = new Jongo(db);
        return jongo.getCollection("cliparts").find("{title:\"PC LAPTOP NOTEBOOK\"}").as(Clipart.class);
    }
}
