package com.meghamlabs.nowinandroidapp.data.datasources

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataSource(private val dataStore: DataStore<UserPreferences>) {

    val bookmarksStream : Flow<List<String>> = dataStore.data.map{
        it.bookmarksMap.keys.toList()
    }

    suspend fun toggleBookmark(newsResourceId: String , isBookmarked: Boolean){

        if(isBookmarked){
            bookmarks.put(newsResourceId,true)
        }else
        {
            booksmark.remove(newsResourceId)
        }

    }
}