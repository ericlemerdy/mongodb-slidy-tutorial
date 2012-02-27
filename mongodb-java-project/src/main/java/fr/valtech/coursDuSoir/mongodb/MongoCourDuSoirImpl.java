package fr.valtech.coursDuSoir.mongodb;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;

import fr.valtech.coursDuSoir.mongodb.model.Clipart;
import fr.valtech.coursDuSoir.mongodb.model.Uploader;

public class MongoCourDuSoirImpl implements MongoCourDuSoir {

    @Override
    public DB connect_tip_use_Mongo_object() throws UnknownHostException {
        throw new UnsupportedOperationException("Tip: instantiate com.mongodb.Mongo object");
    }

    @Override
    public Jongo create_tip_use_jongo_object() throws UnknownHostException {
        throw new UnsupportedOperationException("Tip: instantiate org.jongo.Jongo object");
    }

    @Override
    public MongoCollection get_cliparts_collection() throws UnknownHostException {
        throw new UnsupportedOperationException("Tip: explore the Jongo API");
    }

    @Override
    public Long count_cliparts() throws UnknownHostException {
        throw new UnsupportedOperationException("Tip: explore the MongoCollection API");
    }

    @Override
    public Iterable<Clipart> find_cliparts_entitled_CodeStoryLogo() throws UnknownHostException {
        throw new UnsupportedOperationException("Tip: explore the MongoCollection API");
    }

    @Override
    public Uploader find_Keistutis_uploader() throws UnknownHostException {
        throw new UnsupportedOperationException("Tip: explore the MongoCollection API");
    }

    @Override
    public void with_writetest_database_create_data(String title, String name, String href)
            throws UnknownHostException, IOException {
        throw new UnsupportedOperationException("Tip: reinit a db and save a document");
    }

    @Override
    public void with_writetest_database_reattribute_clipart_entitled_PC_LAPTOP_NOTEBOOK() throws UnknownHostException {
        throw new UnsupportedOperationException("Tip: reinit a db and update a document");
    }

    @Override
    public Iterable<Clipart> with_writetest_database_find_cliparts_entitled_PC_LAPTOP_NOTEBOOK()
            throws UnknownHostException {
        throw new UnsupportedOperationException("Tip: reinit a db and mimic a similar implementation");
    }
}
