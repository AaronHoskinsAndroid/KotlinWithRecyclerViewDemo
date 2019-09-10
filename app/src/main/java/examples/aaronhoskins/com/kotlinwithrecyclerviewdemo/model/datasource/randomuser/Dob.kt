package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Dob : Parcelable {

    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("age")
    @Expose
    var age: Int? = null

    protected constructor(`in`: Parcel) {
        this.date = `in`.readValue(String::class.java.classLoader) as String?
        this.age = `in`.readValue(Int::class.java.classLoader) as Int?
    }

    constructor() {}

    constructor(date: String, age: Int?) : super() {
        this.date = date
        this.age = age
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(date)
        dest.writeValue(age)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Dob> = object : Parcelable.Creator<Dob> {

            override fun createFromParcel(`in`: Parcel): Dob = Dob(`in`)

            override fun newArray(size: Int): Array<Dob?> = arrayOfNulls(size)

        }
    }

}
