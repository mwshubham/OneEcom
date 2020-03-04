package app.oneecom.core.network.responses

import android.os.Parcelable
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: Long,
    val name: String,
    val imageUrl: String?,
    val child: List<Category>?
) : ExpandableGroup<Category>(
    name, child
), Parcelable {
    fun showExpandIcon() = child.isNullOrEmpty()
}