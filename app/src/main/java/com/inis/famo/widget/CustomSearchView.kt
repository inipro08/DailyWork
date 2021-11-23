package com.inis.famo.widget

import android.annotation.SuppressLint
import android.app.Activity
import android.app.SearchManager
import android.content.Context
import android.inputmethodservice.Keyboard
import android.util.AttributeSet
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import com.inis.famo.R
import com.inis.famo.utils.LazySearch
import com.inis.famo.utils.hideKeyboard
import com.inis.famo.utils.showKeyboard

@SuppressLint("CustomViewStyleable")
class CustomSearchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var editSearch: SearchView
    private var listener: ((keyword: String) -> Unit)? = null
    var isDelaySearch: Boolean = false
    private var lazySearch = LazySearch(::submitSearch)

    init {
        inflate(context, R.layout.widget_search, this)
        editSearch = findViewById(R.id.edit_search)

        editSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!isDelaySearch) {
                    submitSearch(newText ?: "")
                } else {
                    lazySearch.search(newText ?: "")
                }
                return false
            }
        })

        editSearch.setOnFocusChangeListener { _, b ->
            if (!b) {
                hideKeyboard()
            }
        }

        if (attrs != null) {
            val styledAttributes =
                context.obtainStyledAttributes(attrs, R.styleable.CustomTaskInfoWidget)
            val placeholder =
                styledAttributes.getString(R.styleable.CustomTaskInfoWidget_placeholder).toString()
            styledAttributes.recycle()
            editSearch.queryHint = placeholder
        }
    }

    private fun submitSearch(newText: String) {
        listener?.invoke(newText)
    }

    fun setupVoiceSearch(activity: Activity) {
        val searchManager = activity.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        editSearch.setSearchableInfo(searchManager.getSearchableInfo(activity.componentName))
    }

    fun setHint(textHint: CharSequence) {
        editSearch.queryHint = textHint
    }

    var text: String
        get() {
            return editSearch.query.toString()
        }
        set(value) {
            editSearch.setQuery(value, false)
        }

    fun setListener(callback: (keyword: String) -> Unit) {
        this.listener = callback
    }

    fun requestSearchFocus() {
        editSearch.showKeyboard()
    }

    fun clearSearchFocus() {
        editSearch.hideKeyboard()
    }
}
