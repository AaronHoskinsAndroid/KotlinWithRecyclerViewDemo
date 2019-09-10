package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Id : Parcelable {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("value")
    @Expose
    var value: Any? = null

    protected constructor(`in`: Parcel) {
        this.name = `in`.readValue(String::class.java.classLoader) as String?
        this.value = `in`.readValue(Any::class.java.classLoader)
    }

    constructor() {}


    constructor(name: String, value: Any) : super() {
        this.name = name
        this.value = value
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(name)
        dest.writeValue(value)
    }

    override fun describeContents(): Int = 0


    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Id> = object : Parcelable.Creator<Id> {

            override fun createFromParcel(`in`: Parcel): Id = Id(`in`)

            override fun newArray(size: Int): Array<Id?> = arrayOfNulls(size)

        }
    }

}
