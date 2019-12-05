package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */

public class JsonNull extends Json {
    private JsonNull el = null;

    @Override
    public String toJson() {
        return String.valueOf(el);
    }
}
