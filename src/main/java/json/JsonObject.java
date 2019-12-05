package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private JsonPair[] jsonPairs;

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
        // ToDo
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        String str = "";
        str += "{";
        for (int j = 0; j < names.length; j++) {
            for (int i = 0; i < jsonPairs.length; i++) {
                if (j != names.length -1){
                if (names[j].equals(jsonPairs[i].key)) {
                    str += names[j];
                    str += ": ";
                    str += jsonPairs[i].value.toJson() + ", ";
                }else {
                    str += jsonPairs[i].key;
                    str += ": ";
                    str += jsonPairs[i].value.toJson();
                }
                }
            }

            str += "}";
            return ;
        }
    }
}

}
