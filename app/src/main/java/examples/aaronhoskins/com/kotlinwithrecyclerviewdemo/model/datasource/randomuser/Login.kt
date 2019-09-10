package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Login : Parcelable {

    @SerializedName("uuid")
    @Expose
    var uuid: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("password")
    @Expose
    var password: String? = null
    @SerializedName("salt")
    @Expose
    var salt: String? = null
    @SerializedName("md5")
    @Expose
    var md5: String? = null
    @SerializedName("sha1")
    @Expose
    var sha1: String? = null
    @SerializedName("sha256")
    @Expose
    var sha256: String? = null

    protected constructor(`in`: Parcel) {
        this.uuid = `in`.readValue(String::class.java.classLoader) as String?
        this.username = `in`.readValue(String::class.java.classLoader) as String?
        this.password = `in`.readValue(String::class.java.classLoader) as String?
        this.salt = `in`.readValue(String::class.java.classLoader) as String?
        this.md5 = `in`.readValue(String::class.java.classLoader) as String?
        this.sha1 = `in`.readValue(String::class.java.classLoader) as String?
        this.sha256 = `in`.readValue(String::class.java.classLoader) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param username
     * @param sha256
     * @param md5
     * @param sha1
     * @param uuid
     * @param password
     * @param salt
     */
    constructor(
        uuid: String,
        username: String,
        password: String,
        salt: String,
        md5: String,
        sha1: String,
        sha256: String
    ) : super() {
        this.uuid = uuid
        this.username = username
        this.password = password
        this.salt = salt
        this.md5 = md5
        this.sha1 = sha1
        this.sha256 = sha256
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(uuid)
        dest.writeValue(username)
        dest.writeValue(password)
        dest.writeValue(salt)
        dest.writeValue(md5)
        dest.writeValue(sha1)
        dest.writeValue(sha256)
    }

    override fun describeContents(): Int = 0


    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Login> = object : Parcelable.Creator<Login> {

            override fun createFromParcel(`in`: Parcel): Login  = Login(`in`)

            override fun newArray(size: Int): Array<Login?> = arrayOfNulls(size)

        }
    }

}
