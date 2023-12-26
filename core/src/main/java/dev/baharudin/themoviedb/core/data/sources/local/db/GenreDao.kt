package dev.baharudin.themoviedb.core.data.sources.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.baharudin.themoviedb.core.data.models.local.Genre

@Dao
interface GenreDao {
    @Query("SELECT * FROM genres")
    fun loadAll(): List<Genre>

    @Query("SELECT * FROM genres WHERE id IN (:genreIds)")
    fun loadAllByIds(genreIds: IntArray): List<Genre>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg genres: Genre)
}