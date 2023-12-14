package ir.divar.database.entity

import androidx.room.ColumnInfo

data class CentroidEntity(
    @ColumnInfo("latitude") val latitude: Double?, @ColumnInfo("longitude") val longitude: Double?
)
