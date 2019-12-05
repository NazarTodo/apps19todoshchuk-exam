package json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private JsonPair[] jsonPairs;
    private List<Tuple> lst;
    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = jsonPairs;
    }

    @Override
    public String toJson() {

        String str = "";
        str += "{";
        for (int i = 0; i < jsonPairs.length; i++) {
            if (i != jsonPairs.length - 1) {
                str += jsonPairs[i].key;
                str += ": ";
                str += jsonPairs[i].value.toJson() + ", ";
            } else {
                str += jsonPairs[i].key;
                str += ": ";
                str += jsonPairs[i].value.toJson();
            }
        }

        str += "}";
        return str;
    }

    public void add(JsonPair jsonPair) {
        List<Tuple> lst= new ArrayList<>();
        lst.add(jsonPair);
    }

    public Json find(String name) {
        Json value = null;
        for (int i = 0; i < jsonPairs.length; i++) {
            if (name.equals(jsonPairs[i].key)) {
                value = jsonPairs[i].value;
            }
        }
        return value;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();


        for (String el : names) {
            if (find(el) != null){
                JsonObject.add(new Tuple<>(el, find(el)));
            }

        }

        System.out.println(lst);
        return new JsonObject();


    }

}
