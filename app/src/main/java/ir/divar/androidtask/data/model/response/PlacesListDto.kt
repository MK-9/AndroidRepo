package ir.divar.androidtask.data.model.response

import com.google.gson.annotations.SerializedName
import ir.divar.androidtask.data.model.dto.CityDto

data class PlacesListDto(@SerializedName("cities") val cities: List<CityDto>?)