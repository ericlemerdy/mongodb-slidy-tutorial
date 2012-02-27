package fr.valtech.coursDuSoir.mongodb;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;

import fr.valtech.coursDuSoir.mongodb.model.Clipart;
import fr.valtech.coursDuSoir.mongodb.model.Uploader;

public interface MongoCourDuSoir {

    DB connect_tip_use_Mongo_object() throws UnknownHostException;

    Jongo create_tip_use_jongo_object() throws UnknownHostException;

    MongoCollection get_cliparts_collection() throws UnknownHostException;

    Long count_cliparts() throws UnknownHostException;

    Iterable<Clipart> find_cliparts_entitled_CodeStoryLogo() throws UnknownHostException;

    Uploader find_Keistutis_uploader() throws UnknownHostException;

    void with_writetest_database_create_data(String title, String name, String href) throws UnknownHostException,
            IOException;

    void with_writetest_database_reattribute_clipart_entitled_PC_LAPTOP_NOTEBOOK() throws UnknownHostException;

    Iterable<Clipart> with_writetest_database_find_cliparts_entitled_PC_LAPTOP_NOTEBOOK() throws UnknownHostException;

}
