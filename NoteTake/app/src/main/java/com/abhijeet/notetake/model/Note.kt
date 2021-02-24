package com.abhijeet.notetake.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note (@PrimaryKey @ColumnInfo(name = "note") val note : String) {
}