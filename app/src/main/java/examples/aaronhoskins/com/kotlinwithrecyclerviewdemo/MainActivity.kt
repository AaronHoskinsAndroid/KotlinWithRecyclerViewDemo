package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser.RandomMeResponse
import examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.remote.retrofit.RandomUserService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins.onError
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    fun initRecyclerView() {
        RandomUserService
            .createService()
            .getRandomUsers("20", "female")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<RandomMeResponse> {
                lateinit var randomMeResponse: RandomMeResponse
                override fun onComplete() {
                    onReuslt(randomMeResponse)
                }

                override fun onError(e: Throwable) {
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("TAG", "Subscribed")
                }

                override fun onNext(t: RandomMeResponse) {
                    randomMeResponse = t
                }
            })
    }

    fun onReuslt(randomMeResponse: RandomMeResponse) {
        val adapter = RandomUserRvAdapter(randomMeResponse.results!!)
        rvRandomUserList.adapter = adapter
        rvRandomUserList.layoutManager = LinearLayoutManager(this)

    }
}
