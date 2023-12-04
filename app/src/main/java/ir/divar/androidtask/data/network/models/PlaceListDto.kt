package ir.divar.androidtask.data.network.models

import com.google.gson.annotations.SerializedName

data class PlaceListDto(@SerializedName("cities") val cities: List<CityDto>?)