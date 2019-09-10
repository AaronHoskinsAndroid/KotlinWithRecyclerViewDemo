package examples.aaronhoskins.com.kotlinwithrecyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import examples.aaronhoskins.com.kotlinwithrecyclerviewdemo.model.datasource.randomuser.Result
import kotlinx.android.synthetic.main.randon_user_item.view.*

class RandomUserRvAdapter(var resultList : List<Result>) :
    RecyclerView.Adapter<RandomUserRvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.randon_user_item, parent, false))

    override fun getItemCount(): Int  = resultList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bindValues(resultList[position])

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindValues(result: Result) {
            itemView.tvEmail.text = result.email
            //String.format("%s %s", result.name?.first , result.name?.last);
            itemView.tvName.text = "${result.name?.first} ${result.name?.last}"
            Glide.with(itemView).load(result.picture?.thumbnail).into(itemView.imgThumbNail)
        }
    }
}