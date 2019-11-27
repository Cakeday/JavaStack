import java.util.HashMap;
import java.util.Set;

public class MapOfTheHash{

    public void map(){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("song1", "a");
        trackList.put("song2", "b");
        trackList.put("song3", "c");
        trackList.put("song4", "d");
        System.out.println(trackList.get("song1"));
        Set<String> keys = trackList.keySet();
        for(String key : keys){
            System.out.println(key+": "+trackList.get(key));
        }
    }
}