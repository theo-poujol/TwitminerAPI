import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;


public class Main {


    static final String CONSUMER_KEY = "W0SFnFGlIMCNWAHvnrDEek2vO";
    static final String CONSUMER_SECRET = "3g6IkQHawFYMdwUxavJpILdktcgIuVH55Dz4i6Mw266l0XZHtC";
    static final String ACCESS_TOKEN = "1101105543534571520-i6RHOhpUohoeCTdAzNnWQgycfxFrQ0";
    static final String ACCESS_TOKEN_SECRET = "tQ0rIXu2uVTWseXybUdlD4qol464gGB5vEhnV0Xha6Wkp";



    private static TwitterFactory Authentification() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf;
    }

    private static void searchByKeyWord(Twitter twitter, String queryToSearch) {

        try {



            //Recherche

            Query query = new Query(queryToSearch);
            query.setCount(90);
            QueryResult result = twitter.search(query);

            for (Status status : result.getTweets()) {
                System.out.println(status.getCreatedAt()); // Date
                System.out.println("@" + status.getUser().getScreenName()); // Récupère l'user et son @username Twitter
                System.out.println(status.getText()); // Le tweet
                System.out.println('\n');

            }

        }

        catch (TwitterException e) {
            e.printStackTrace();
        }




    }



    public static void main (String[] args) {

    /*Twitter t = getTwitterInstance();
    showHomeTimeline(t);*/

        Convert.ConvertCSVToTrans("test.txt");

        //Authentification
        TwitterFactory tf = Authentification();
        System.out.println("Bien connecté à Twitter");

        Twitter twitter = tf.getInstance();
        searchByKeyWord(twitter, "Marseille");


    }

}

