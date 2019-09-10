package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.remote.retrofit

import examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser.RandomMeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface RandomUserService{
    //companion object ~ static methods
    companion object{
        fun createService() : RandomUserService =
            RetrofitHelper().getRetrofitInstance().create(RandomUserService::class.java)
    }

    @GET("api/")
    fun getRandomUsers(@Query("results")resultCount : String, @Query("gender")gender : String)
            : Observable<RandomMeResponse>
}