package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Info : Parcelable {

    @SerializedName("seed")
    @Expose
    var seed: String? = null
    @SerializedName("results")
    @Expose
    var results: Int? = null
    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("version")
    @Expose
    var version: String? = null

    protected constructor(`in`: Parcel) {
        this.seed = `in`.readValue(String::class.java.classLoader) as String?
        this.results = `in`.readValue(Int::class.java.classLoader) as Int?
        this.page = `in`.readValue(Int::class.java.classLoader) as Int?
        this.version = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param results
     * @param page
     * @param seed
     * @param version
     */
    constructor(seed: String, results: Int?, page: Int?, version: String) : super() {
        this.seed = seed
        this.results = results
        this.page = page
        this.version = version
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(seed)
        dest.writeValue(results)
        dest.writeValue(page)
        dest.writeValue(version)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Info> = object : Parcelable.Creator<Info> {


            override fun createFromParcel(`in`: Parcel): Info {
                return Info(`in`)
            }

            override fun newArray(size: Int): Array<Info?> =
                arrayOfNulls(size)


        }
    }

}
