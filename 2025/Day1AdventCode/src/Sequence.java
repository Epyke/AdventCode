import java.util.HashMap;

public class Sequence {
    private HashMap<Integer, Integer> map;
    private Dial d;
    public Sequence(Dial d){
        map = new HashMap<>();
        this.d = d;
    }

    public void storeSequence(){
        map.put(d.getDegree(), map.getOrDefault(d.getDegree(), 0) + 1);
    }

    public int getPassword(){
        return map.get(0);
    }
}
