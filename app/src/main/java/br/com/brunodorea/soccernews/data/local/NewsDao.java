package br.com.brunodorea.soccernews.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.brunodorea.soccernews.domain.News;

@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(News news);

    @Query("SELECT * FROM news WHERE favorite = 1")
    LiveData<List<News>> loadFavoriteNews();
}