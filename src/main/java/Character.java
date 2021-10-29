import com.fasterxml.jackson.annotation.JsonProperty;

public class Character {

    @JsonProperty("characterage")
    public int age;
    @JsonProperty("charactername")
    public String name;
    @JsonProperty("characterheight")
    public int height;

    public Character(String name, int age, int height) {
        this.name = name;
        this.height = height;
        this.age = age;
    }


}
