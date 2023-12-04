package ir.divar.androidtask.data.model.dto

import com.google.gson.annotations.SerializedName
import ir.divar.androidtask.data.model.dto.CityDto

data class PlaceListDto(@SerializedName("cities") val cities: List<CityDto>?)