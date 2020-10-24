package cl.nodalnet.plaplixgoods.models.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllData(mSowingListDB: List<ProductsItem>)

    @Query("SELECT * FROM master_table")
    fun getAllData(): LiveData<List<ProductsItem>>

    @Query("SELECT * FROM master_table WHERE name=:mName")
    fun getOneGoods(mName: String): LiveData<ProductsItem>

}