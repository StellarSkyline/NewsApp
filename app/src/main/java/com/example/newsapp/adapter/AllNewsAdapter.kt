import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.DataItem
import com.example.newsapp.databinding.ItemAllNewsBinding

class AllNewsAdapter(val data: List<DataItem>) : RecyclerView.Adapter<AllNewsAdapter.ViewHolder>() {

    //creating view holder
    inner class ViewHolder(val binding: ItemAllNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(ItemAllNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text = data[position].title
    }
}