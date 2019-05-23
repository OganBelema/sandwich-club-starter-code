package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject sandwichJsonObject = jsonObject.getJSONObject("name");
            String mainName = sandwichJsonObject.getString("mainName");
            JSONArray alsoKnownAsJSONArray = sandwichJsonObject.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<>();

            if (alsoKnownAsJSONArray != null){
                for (int i = 0; i < alsoKnownAsJSONArray.length(); i++){
                    alsoKnownAs.add(alsoKnownAsJSONArray.getString(i));
                }
            }

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            JSONArray ingredientsJSONArray = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();

            if (ingredientsJSONArray != null){
                for (int i = 0; i < ingredientsJSONArray.length(); i++){
                    ingredients.add(ingredientsJSONArray.getString(i));
                }
            }

            sandwich = new Sandwich();
            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setIngredients(ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
