package ir.divar.network.models

import com.google.gson.annotations.SerializedName

data class PlaceListDto(@SerializedName("cities") val cities: List<CityDto>?)