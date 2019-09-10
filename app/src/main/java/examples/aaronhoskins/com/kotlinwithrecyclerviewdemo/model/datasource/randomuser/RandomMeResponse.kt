package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RandomMeResponse : Parcelable {

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("info")
    @Expose
    var info: Info? = null

    protected constructor(`in`: Parcel) {
        `in`.readList(
            this.results!!, Result::class.java!!.getClassLoader()
        )
        this.info = `in`.readValue(Info::class.java.classLoader) as Info?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param results
     * @param info
     */
    constructor(results: List<Result>, info: Info) : super() {
        this.results = results
        this.info = info
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeList(results)
        dest.writeValue(info)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RandomMeResponse> =
            object : Parcelable.Creator<RandomMeResponse> {


                override fun createFromParcel(`in`: Parcel): RandomMeResponse {
                    return RandomMeResponse(`in`)
                }

                override fun newArray(size: Int): Array<RandomMeResponse?> {
                    return arrayOfNulls(size)
                }

            }
    }

}
