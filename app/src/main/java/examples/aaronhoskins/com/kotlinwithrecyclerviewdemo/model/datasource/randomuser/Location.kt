package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location : Parcelable {

    @SerializedName("street")
    @Expose
    var street: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("postcode")
    @Expose
    var postcode: String? = null
    @SerializedName("coordinates")
    @Expose
    var coordinates: Coordinates? = null
    @SerializedName("timezone")
    @Expose
    var timezone: Timezone? = null

    protected constructor(`in`: Parcel) {
        this.street = `in`.readValue(String::class.java.classLoader) as String?
        this.city = `in`.readValue(String::class.java.classLoader) as String?
        this.state = `in`.readValue(String::class.java.classLoader) as String?
        this.postcode = `in`.readValue(String::class.java.classLoader) as String?
        this.coordinates = `in`.readValue(Coordinates::class.java.classLoader) as Coordinates?
        this.timezone = `in`.readValue(Timezone::class.java.classLoader) as Timezone?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param timezone
     * @param street
     * @param state
     * @param postcode
     * @param coordinates
     * @param city
     */
    constructor(
        street: String,
        city: String,
        state: String,
        postcode: String,
        coordinates: Coordinates,
        timezone: Timezone
    ) : super() {
        this.street = street
        this.city = city
        this.state = state
        this.postcode = postcode
        this.coordinates = coordinates
        this.timezone = timezone
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(street)
        dest.writeValue(city)
        dest.writeValue(state)
        dest.writeValue(postcode)
        dest.writeValue(coordinates)
        dest.writeValue(timezone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Location> = object : Parcelable.Creator<Location> {

            override fun createFromParcel(`in`: Parcel): Location = Location(`in`)

            override fun newArray(size: Int): Array<Location?> = arrayOfNulls(size)

        }
    }

}
