/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import twitter4j.Twitter;
import java.util.List;
//import twitter4j.Twitter;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserMentionEntity;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;
/**
 *
 * @author Luis
 */
public class Twitter {
  private String consumer_key="iKRGfs4BVTt1D7vICixKRmJUJ";  
  private String consumer_secret="73ZibURdOwnYtbNOewsTVGjCKX3s2Lv7cL1iqM5nF1LfEF3iQW";
  private String oauth_token="2484444423-8TPTOvFzZHhGUcyOkqECzcwAoBmhn7eXDNRu0lv";
  private String oauth_token_secret="SjkCRLxsiqHIIrM2UoD3i9eqAW6A70Lr7x1gYOFQAIopb";
		  
    public Twitter() {
        
    }
    
    public void getInformacion(String usuario) throws TwitterException{
        ConfigurationBuilder cb = new ConfigurationBuilder();  
        cb.setDebugEnabled(true);  
        cb.setOAuthConsumerKey(consumer_key);  
        cb.setOAuthConsumerSecret(consumer_secret);  
        cb.setOAuthAccessToken(oauth_token);  
        cb.setOAuthAccessTokenSecret(oauth_token_secret); 
        cb.setJSONStoreEnabled(true);
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter=(twitter4j.Twitter) tf.getInstance();
        Paging paging = new Paging(1, 50);
        List<Status> data = twitter.getUserTimeline(usuario ,paging);
        for(Status tweet: data){
            String statusJson = DataObjectFactory.getRawJSON(data);
            //System.out.println(statusJson);
           
           System.out.println(" ID: " + tweet.getId() + " Texto: " + tweet.getText() + "#Retweet: " + tweet.getRetweetCount() );
        }
        System.out.println("finnn");
    }
      //twitter = tf.getOAuthAuthorizedInstance (consumer_key, consumer_secret, new AccessToken( oauth_token, oauth_token_secret));
    
}
