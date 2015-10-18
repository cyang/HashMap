/**
 * @author Christopher Yang <cyang001@citymail.cuny.edu>
 */

/**
 * Class an HashMap entry.
 */
public class MapData {
    public MapData next;
    final private String key;

    public MapData(String key){
        this.next = null;
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
