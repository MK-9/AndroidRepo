package ir.divar.database.new_entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "widgets", foreignKeys = [ForeignKey(
        entity = Data::class,
        parentColumns = ["id"],
        childColumns = ["dataId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class Widget(
    @PrimaryKey(autoGenerate = true) val id: Int, val widgetType: String, val dataId: Long
)
