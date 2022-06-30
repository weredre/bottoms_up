package com.example.bottoms_up.model.response


import com.google.gson.annotations.SerializedName

data class DrinkDetailDTO(
    val drinks: List<Drink>
) {
    data class Drink(
        val dateModified: String,
        val idDrink: String,
        val strAlcoholic: String,
        val strCategory: String,
        val strCreativeCommonsConfirmed: String,
        val strDrink: String,
        val strDrinkAlternate: Any?,
        val strDrinkThumb: String,
        val strGlass: String,
        val strIBA: Any?,
        val strImageAttribution: Any?,
        val strImageSource: Any?,
        val strIngredient1: String,
        val strIngredient10: Any?,
        val strIngredient11: Any?,
        val strIngredient12: Any?,
        val strIngredient13: Any?,
        val strIngredient14: Any?,
        val strIngredient15: Any?,
        val strIngredient2: String,
        val strIngredient3: String,
        val strIngredient4: String,
        val strIngredient5: String,
        val strIngredient6: String,
        val strIngredient7: String,
        val strIngredient8: String,
        val strIngredient9: String,
        val strInstructions: String,
        val strInstructionsDE: String,
        val strInstructionsES: Any?,
        val strInstructionsFR: Any?,
        val strInstructionsIT: String,
        @SerializedName("strInstructionsZH-HANS")
        val strInstructionsZHHANS: Any?,
        @SerializedName("strInstructionsZH-HANT")
        val strInstructionsZHHANT: Any?,
        val strMeasure1: String,
        val strMeasure10: Any?,
        val strMeasure11: Any?,
        val strMeasure12: Any?,
        val strMeasure13: Any?,
        val strMeasure14: Any?,
        val strMeasure15: Any?,
        val strMeasure2: String,
        val strMeasure3: String,
        val strMeasure4: String,
        val strMeasure5: String,
        val strMeasure6: String,
        val strMeasure7: String,
        val strMeasure8: String,
        val strMeasure9: String,
        val strTags: Any?,
        val strVideo: Any?
    )
}