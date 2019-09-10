package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coordinates : Parcelable {

    @SerializedName("latitude")
    @Expose
    var latitude: String? = null
    @SerializedName("longitude")
    @Expose
    var longitude: String? = null

    protected constructor(`in`: Parcel) {
        this.latitude = `in`.readValue(String::class.java.classLoader) as String?
        this.longitude = `in`.readValue(String::class.java.classLoader) as String?
    }

    constructor(latitude: String, longitude: String) : super() {
        this.latitude = latitude
        this.longitude = longitude
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(latitude)
        dest.writeValue(longitude)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Coordinates> = object : Parcelable.Creator<Coordinates> {
            override fun createFromParcel(`in`: Parcel): Coordinates = Coordinates(`in`)

            override fun newArray(size: Int): Array<Coordinates?> = arrayOfNulls(size)
        }
    }

}
