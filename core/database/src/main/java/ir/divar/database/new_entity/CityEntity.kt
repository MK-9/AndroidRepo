package ir.divar.database.new_entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
  data class CityEntity(
    @PrimaryKey val id: Int?,
    val name: String?,
    val slug: String?,
    val radius: Int?,
    @Embedded val centroid: CentroidEntity?
)
