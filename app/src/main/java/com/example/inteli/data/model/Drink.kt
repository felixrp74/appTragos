package com.example.inteli.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    @SerializedName("idDrink")
<<<<<<< HEAD
    val tragoId: String = "",
=======
    val tragoId:String="",
>>>>>>> bab6224829fce076904cbcb3e82fbca94a754642
    @SerializedName("strDrinkThumb")
    val imagen: String = "",
    @SerializedName("strDrink")
    val nombre: String = "",
    @SerializedName("strInstructions")
    val descripcion: String = "",
    @SerializedName("strAlcoholic")
    val conAlcohol: String = ""

) : Parcelable

data class DrinkList(@SerializedName("drinks") val drinkList: List<Drink>)

<<<<<<< HEAD
@Entity(tableName = "tragoEntity")
data class DrinkEntity(
    @PrimaryKey
    val tragoId: String = "",
=======
@Entity(tableName = "tragosEntity")
data class DrinkEntity(
    @PrimaryKey
    val idDrink:String,
>>>>>>> bab6224829fce076904cbcb3e82fbca94a754642
    @ColumnInfo(name = "trago_imagen")
    val imagen: String = "",
    @ColumnInfo(name = "trago_nombre")
    val nombre: String = "",
    @ColumnInfo(name = "trago_descripcion")
    val descripcion: String = "",
<<<<<<< HEAD
    @ColumnInfo(name = "trago_con_alcoholk")
    val conAlcohol: String = ""
)


=======
    @ColumnInfo(name = "trago_has_alcohol")
    val conAlcohol: String = "Non_Alcoholic"

)



>>>>>>> bab6224829fce076904cbcb3e82fbca94a754642
