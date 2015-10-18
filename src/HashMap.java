/**
 * @author Christopher Yang <cyang001@citymail.cuny.edu>
 */

/**
 * Class for a chained HashMap that takes in String keys and MapData values.
 */
public class HashMap {

    private int size;
    private int count;

    private MapData[] map;

    public HashMap(int size){
        //return an instance of the class with pre-allocated space for the given number of objects.
        this.size = size;
        count = 0;
        map = new MapData[size];
    }

    public boolean set(String key, MapData value) {
        //stores the given key/value pair in the hash map. Returns a boolean value indicating success / failure of the operation.

        // Find the hashvalue so that it is within the array size
        int hash = key.hashCode() % size;
        if (hash < 0)
            hash = -hash;

        MapData cursor = map[hash];

        if (cursor == null){
            map[hash] = value;
            count++;
            return true;
        }

        // Do not set the MapData if it already exists in the HashMap
        if(cursor.getKey().equals(key))
            return false;

        // Look for an empty node in the chained HashMap; also check for duplicate MapData
        while(cursor.next != null) {
            if(cursor.getKey().equals(key))
                return false;

            cursor = cursor.next;
        }

        // Add the MapData value
        cursor.next = value;
        count++;
        
        return true;
    }


    public MapData get(String key){
        //return the value associated with the given key, or null if no value is set.

        // Find the hashvalue so that it is within the array size
        int hash = key.hashCode() % size;
        if (hash < 0)
            hash = -hash;
        
        MapData cursor = map[hash];

        // Look for the MapData value
        while(cursor != null){
            if(cursor.getKey().equals(key))
                return cursor;

            cursor = cursor.next;
        }

        // Return null if the cursor points to null
        return null;
    }

    public MapData delete(String key){
        //delete the value associated with the given key, returning the value on success or null if the key has no value.

        // Find the hashvalue so that it is within the array size
        int hash = key.hashCode() % size;
        if (hash < 0)
            hash = -hash;

        MapData cursor = map[hash];

        // Nothing to delete
        if (cursor == null)
            return null;

        MapData temp = cursor;

        if (cursor.getKey().equals(key)){
            // Found the MapData
            temp = cursor;
            map[hash] = null;
            count--;
        } else {
            // Check the chained list of the HashMap
            while(cursor.next != null){
                if(cursor.next.getKey().equals(key)){
                    temp = cursor.next;
                    cursor.next = null;
                    count--;
                    break;
                }
                cursor = cursor.next;
            }
        }

        return temp;
    }

    public float load() {
        //return a float value representing the load factor (`(items in hash map)/(size of hash map)`) of the data structure. Since the size of the dat structure is fixed, this should never be greater than 1.
        return (float) count/size;
    }
}
