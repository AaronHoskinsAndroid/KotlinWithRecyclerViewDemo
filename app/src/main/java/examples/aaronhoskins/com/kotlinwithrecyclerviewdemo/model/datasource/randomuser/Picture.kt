package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Picture : Parcelable {

    @SerializedName("large")
    @Expose
    var large: String? = null
    @SerializedName("medium")
    @Expose
    var medium: String? = null
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null

    protected constructor(`in`: Parcel) {
        this.large = `in`.readValue(String::class.java.classLoader) as String?
        this.medium = `in`.readValue(String::class.java.classLoader) as String?
        this.thumbnail = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param thumbnail
     * @param medium
     * @param large
     */
    constructor(large: String, medium: String, thumbnail: String) : super() {
        this.large = large
        this.medium = medium
        this.thumbnail = thumbnail
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(large)
        dest.writeValue(medium)
        dest.writeValue(thumbnail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Picture> = object : Parcelable.Creator<Picture> {


            override fun createFromParcel(`in`: Parcel): Picture {
                return Picture(`in`)
            }

            override fun newArray(size: Int): Array<Picture?> {
                return arrayOfNulls(size)
            }

        }
    }

}
