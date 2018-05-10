package test;

import configs.Configs;
import methods.Method;
import org.json.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.json.JSONArray;
import org.json.JSONException;

public class GetTest {
    static Configs configs = new Configs();
    static Method method = new Method();

    @Test
    public void apiTest() throws JSONException {


        JSONObject jsonResponse = null;
        // получаю человека Люк Скайвокер
        jsonResponse = method.getMethod(configs.getConfigsApp().get("baseUrl") + "people/1/");
        String mainHero = String.valueOf(jsonResponse.get("name"));
        AssertJUnit.assertEquals(mainHero, "Luke Skywalker");

        String homeworld = String.valueOf(jsonResponse.get("homeworld"));
        jsonResponse = method.getMethod(homeworld);

        String population = String.valueOf(jsonResponse.get("population"));
        AssertJUnit.assertEquals(population, "200000");

        String planetName = String.valueOf(jsonResponse.get("name"));
        AssertJUnit.assertEquals(planetName, "Tatooine");

        JSONArray films = jsonResponse.getJSONArray("films");
        jsonResponse = method.getMethod(String.valueOf(films.get(0)));

        String filmName = String.valueOf(jsonResponse.get("title"));
        AssertJUnit.assertEquals(filmName, "Attack of the Clones");

        if (String.valueOf(jsonResponse).contains(planetName)){
            System.out.println(planetName + " was in this: \"" + filmName + "\" film");
        } else {
            System.out.println(planetName + " doesn't show in this: \"" + filmName + "\" film");
        }
        if (String.valueOf(jsonResponse).contains(mainHero)){
            System.out.println(mainHero + " was in this: \"" + filmName + "\" film");
        } else {
            System.out.println(mainHero + " doesn't show in this: \"" + filmName + "\" film");
        }



    }

}