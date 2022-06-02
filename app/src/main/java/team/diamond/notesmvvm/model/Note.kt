package team.diamond.notesmvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_table")



data class Note(
    @PrimaryKey(autoGenerate = true)  //аннотации необходимы для корректой работы локальной базы room
    val id:Int =0,
    @ColumnInfo           //аннотация
    val title: String,
    @ColumnInfo           //аннотация
    val subtitle: String

)
