package ir.divar.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityEntity(
    @ColumnInfo("name") val name: String?,
    @PrimaryKey val id: Int?,
    @ColumnInfo("slug") val slug: String?,
    @ColumnInfo("radius") val radius: Int?,
    @Embedded val centroid: CentroidEntity?
)
