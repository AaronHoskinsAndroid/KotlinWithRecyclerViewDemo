package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Name : Parcelable {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("first")
    @Expose
    var first: String? = null
    @SerializedName("last")
    @Expose
    var last: String? = null

    protected constructor(`in`: Parcel) {
        this.title = `in`.readValue(String::class.java.classLoader) as String?
        this.first = `in`.readValue(String::class.java.classLoader) as String?
        this.last = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param title
     * @param last
     * @param first
     */
    constructor(title: String, first: String, last: String) : super() {
        this.title = title
        this.first = first
        this.last = last
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(title)
        dest.writeValue(first)
        dest.writeValue(last)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Name> = object : Parcelable.Creator<Name> {

            override fun createFromParcel(`in`: Parcel): Name = Name(`in`)

            override fun newArray(size: Int): Array<Name?> = arrayOfNulls(size)


        }
    }

}
