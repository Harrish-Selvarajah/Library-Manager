package model;

import com.fasterxml.jackson.databind.JsonNode;
import org.bson.Document;

import java.util.List;

public interface LibraryManager {

   void adddBook(JsonNode json);
   void adddDvd (JsonNode json);
   //void getbook();
   List<Document> retreivebook();
   List<Document> retreivedvd();
   void deletebook(String isbn);
   void deletedvd(int dvdid);
}
