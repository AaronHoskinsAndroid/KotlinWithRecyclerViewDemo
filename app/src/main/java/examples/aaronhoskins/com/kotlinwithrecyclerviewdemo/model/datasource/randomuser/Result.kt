package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result : Parcelable {

    @SerializedName("gender")
    @Expose
    var gender: String? = null
    @SerializedName("name")
    @Expose
    var name: Name? = null
    @SerializedName("location")
    @Expose
    var location: Location? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("login")
    @Expose
    var login: Login? = null
    @SerializedName("dob")
    @Expose
    var dob: Dob? = null
    @SerializedName("registered")
    @Expose
    var registered: Registered? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("cell")
    @Expose
    var cell: String? = null
    @SerializedName("id")
    @Expose
    var id: Id? = null
    @SerializedName("picture")
    @Expose
    var picture: Picture? = null
    @SerializedName("nat")
    @Expose
    var nat: String? = null

    protected constructor(`in`: Parcel) {
        this.gender = `in`.readValue(String::class.java.classLoader) as String?
        this.name = `in`.readValue(Name::class.java.classLoader) as Name?
        this.location = `in`.readValue(Location::class.java.classLoader) as Location?
        this.email = `in`.readValue(String::class.java.classLoader) as String?
        this.login = `in`.readValue(Login::class.java.classLoader) as Login?
        this.dob = `in`.readValue(Dob::class.java.classLoader) as Dob?
        this.registered = `in`.readValue(Registered::class.java.classLoader) as Registered?
        this.phone = `in`.readValue(String::class.java.classLoader) as String?
        this.cell = `in`.readValue(String::class.java.classLoader) as String?
        this.id = `in`.readValue(Id::class.java.classLoader) as Id?
        this.picture = `in`.readValue(Picture::class.java.classLoader) as Picture?
        this.nat = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param picture
     * @param id
     * @param phone
     * @param email
     * @param location
     * @param registered
     * @param cell
     * @param dob
     * @param name
     * @param gender
     * @param nat
     * @param login
     */
    constructor(
        gender: String,
        name: Name,
        location: Location,
        email: String,
        login: Login,
        dob: Dob,
        registered: Registered,
        phone: String,
        cell: String,
        id: Id,
        picture: Picture,
        nat: String
    ) : super() {
        this.gender = gender
        this.name = name
        this.location = location
        this.email = email
        this.login = login
        this.dob = dob
        this.registered = registered
        this.phone = phone
        this.cell = cell
        this.id = id
        this.picture = picture
        this.nat = nat
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(gender)
        dest.writeValue(name)
        dest.writeValue(location)
        dest.writeValue(email)
        dest.writeValue(login)
        dest.writeValue(dob)
        dest.writeValue(registered)
        dest.writeValue(phone)
        dest.writeValue(cell)
        dest.writeValue(id)
        dest.writeValue(picture)
        dest.writeValue(nat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Result> = object : Parcelable.Creator<Result> {


            override fun createFromParcel(`in`: Parcel): Result {
                return Result(`in`)
            }

            override fun newArray(size: Int): Array<Result?> {
                return arrayOfNulls(size)
            }

        }
    }

}
